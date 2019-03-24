package tech.teslex.telegroo.simple

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import groovy.transform.CompileStatic
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.Telegroo
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.api.update.CommandUpdateHandler
import tech.teslex.telegroo.api.update.MessageUpdateHandler
import tech.teslex.telegroo.api.update.UpdateHandler
import tech.teslex.telegroo.api.update.UpdateHandlersSolver
import tech.teslex.telegroo.simple.context.SimpleContext
import tech.teslex.telegroo.simple.update.SimpleUpdateHandlersSolver
import tech.teslex.telegroo.simple.update.closure.SimpleClosureCommandUpdateHandler
import tech.teslex.telegroo.simple.update.closure.SimpleClosureMessageUpdateHandler
import tech.teslex.telegroo.simple.update.closure.SimpleClosureUpdateHandler
import tech.teslex.telegroo.telegram.enums.UpdateType
import tech.teslex.telegroo.telegram.types.update.Update

@CompileStatic
class SimpleTelegroo extends SimpleContext implements Telegroo<Response> {

	String token

	List<UpdateHandler> handlers = []

	List<Closure<Boolean>> middlewareList = []

	UpdateHandlersSolver updateHandlersSolver = new SimpleUpdateHandlersSolver(this)

	Boolean active = false

	String defaultCommandSymbol = '/'

	SimpleTelegroo(String token) {
		this.objectMapper = new ObjectMapper()
		this.objectMapper.registerModule(new Jdk8Module())
		this.objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)

		this.token = token
		this.lastUpdate = new Update(updateId: 0)
		this.api = new SimpleApi(token, objectMapper)
	}

	@Override
	void start() {
		if (active)
			return

		active = true

		while (active) {
			def response = getUpdates(offset: lastUpdate.updateId + 1)

			if (response && response.ok && response.result)
				for (update in response.result)
					solveUpdate(update)
		}
	}

	@Override
	void stop() {
		active = false
	}

	@Override
	void solveUpdate(Update update) {
		lastUpdate = update
		if (checkMid(lastUpdate))
			updateHandlersSolver.solve(lastUpdate, handlers)
	}

	@Override
	void on(UpdateType updateType, @DelegatesTo(MethodsContext) Closure handler) {
		handlers << new SimpleClosureUpdateHandler(updateType, handler)
	}

	void on(String updateType, @DelegatesTo(MethodsContext) Closure handler) {
		handlers << new SimpleClosureUpdateHandler(UpdateType.fromString(updateType), handler)
	}

	@Override
	void onUpdate(@DelegatesTo(MethodsContext) Closure handler) {
		handlers << new SimpleClosureUpdateHandler(handler)
	}

	@Override
	void onCommand(String command, @DelegatesTo(MethodsContext) Closure handler) {
		handlers << new SimpleClosureCommandUpdateHandler(command, handler)
	}

	@Override
	void onMessage(String message, @DelegatesTo(MethodsContext) Closure handler) {
		handlers << new SimpleClosureMessageUpdateHandler(message, handler)
	}

	@Override
	void onMessage(@DelegatesTo(MethodsContext) Closure handler) {
		handlers << new SimpleClosureUpdateHandler(UpdateType.MESSAGE, handler)
	}

	@Override
	void onUpdateHandler(UpdateHandler handler) {
		handlers << handler
	}

	@Override
	void onCommandUpdateHandler(CommandUpdateHandler handler) {
		handlers << handler
	}

	@Override
	void onMessageUpdateHandler(MessageUpdateHandler handler) {
		handlers << handler
	}

	@Override
	void middleware(Closure<Boolean> closure) {
		middlewareList.add(closure)
	}

	Boolean checkMid(Update update) {
		for (middleware in middlewareList)
			if (!middleware(update))
				return false

		return true
	}
}