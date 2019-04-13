package tech.teslex.telegroo.simple

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import groovy.transform.CompileStatic
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
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.enums.UpdateType
import tech.teslex.telegroo.telegram.types.update.Update

@CompileStatic
class SimpleTelegroo implements Telegroo {

	String token

	Map<UpdateType, List<UpdateHandler>> handlers = [:]

	List<Closure<Boolean>> middlewareList = []

	UpdateHandlersSolver updateHandlersSolver

	Boolean active = false

	SimpleContext mainContext

	protected SimpleTelegroo() {}

	SimpleTelegroo(String token) {
		ObjectMapper mapper = new ObjectMapper().tap {
			registerModule(new Jdk8Module())
			configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
		}

		this.token = token
		this.mainContext = new SimpleContext(new SimpleTelegramClient(token, mapper), new Update(updateId: 0), mapper)
		this.updateHandlersSolver = new SimpleUpdateHandlersSolver(this)
	}

	@Override
	void start() {
		if (active)
			return

		active = true

		while (active) {
			TelegramResult<List<Update>> response = mainContext.getUpdates(offset: mainContext.update.updateId + 1)

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
		this.mainContext.update = update
		if (checkMid(this.mainContext.update))
			updateHandlersSolver.solve(this.mainContext.update, handlers)
	}

	@Override
	void update(UpdateType updateType, @DelegatesTo(MethodsContext) Closure handler) {
		if (!handlers.containsKey(updateType)) handlers.put(updateType, [])
		handlers[updateType] << new SimpleClosureUpdateHandler(updateType, handler)
	}

	void update(String updateType, @DelegatesTo(MethodsContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.fromString(updateType))) handlers.put(UpdateType.fromString(updateType), [])
		handlers[UpdateType.fromString(updateType)] << new SimpleClosureUpdateHandler(UpdateType.fromString(updateType), handler)
	}

	@Override
	void update(@DelegatesTo(MethodsContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.UPDATE)) handlers.put(UpdateType.UPDATE, [])
		handlers[UpdateType.UPDATE] << new SimpleClosureUpdateHandler(handler)
	}

	@Override
	void command(String command, @DelegatesTo(MethodsContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, [])
		handlers[UpdateType.MESSAGE] << new SimpleClosureCommandUpdateHandler(command, handler)
	}

	@Override
	void message(String message, @DelegatesTo(MethodsContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, [])
		handlers[UpdateType.MESSAGE] << new SimpleClosureMessageUpdateHandler(message, handler)
	}

	@Override
	void message(@DelegatesTo(MethodsContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, [])
		handlers[UpdateType.MESSAGE] << new SimpleClosureUpdateHandler(UpdateType.MESSAGE, handler)
	}

	@Override
	void updateHandler(UpdateHandler handler) {
		if (!handlers.containsKey(UpdateType.UPDATE)) handlers.put(UpdateType.UPDATE, [])
		handlers[UpdateType.UPDATE] << handler
	}

	@Override
	void commandUpdateHandler(CommandUpdateHandler handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, [])
		handlers[UpdateType.MESSAGE] << handler
	}

	@Override
	void messageUpdateHandler(MessageUpdateHandler handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, [])
		handlers[UpdateType.MESSAGE] << handler
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