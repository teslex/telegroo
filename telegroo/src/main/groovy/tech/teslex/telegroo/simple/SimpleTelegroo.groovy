package tech.teslex.telegroo.simple

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Telegroo
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.api.update.UpdateHandler
import tech.teslex.telegroo.api.update.UpdateHandlersSolver
import tech.teslex.telegroo.simple.context.SimpleContext
import tech.teslex.telegroo.simple.update.SimpleUpdateHandlersSolver
import tech.teslex.telegroo.telegram.enums.UpdateType
import tech.teslex.telegroo.telegram.types.update.Update

@CompileStatic
class SimpleTelegroo extends SimpleContext implements Telegroo {

	private String token

	private Map handlersClosures = [
			(UpdateType.MESSAGE): [:] as Map<String, Closure>,
			(UpdateType.UPDATE) : [] as List<Closure>
	]

	private Map handlersUpdates = [
			(UpdateType.MESSAGE): [:] as Map<String, UpdateHandler>,
			(UpdateType.UPDATE) : [] as List<UpdateHandler>
	]

	private List<Closure<Boolean>> middles = []

	private UpdateHandlersSolver updateHandlersSolver

	private Boolean active = false

	public String commandSymbol = '/'

	private ObjectMapper jacksonObjectMapper

	SimpleTelegroo(String token) {
		super(new SimpleApi(token), new Update(updateId: 0))

		this.token = token
		this.updateHandlersSolver = new SimpleUpdateHandlersSolver(this)
		this.jacksonObjectMapper = new ObjectMapper()
		this.jacksonObjectMapper.registerModule(new Jdk8Module())
	}

	def start() {
		if (active)
			return

		active = true

		while (active) {
			def response = getUpdates(offset: lastUpdate.updateId + 1)

			if (response && response.ok && response.result)
				for (update in response.result)
					solve(update)
		}
	}

	def stop() {
		active = false
	}

	boolean checkMid(Update update) {
		for (mid in middles)
			if (!mid(update))
				return false

		return true
	}

	void solve(Update update) {
		lastUpdate = update
		if (checkMid(lastUpdate))
			updateHandlersSolver.solve(lastUpdate, handlersClosures, handlersUpdates)
	}

	@Override
	void on(UpdateType updateType, @DelegatesTo(MethodsContext) Closure handler) {
		if (handlersClosures.containsKey(updateType))
			(handlersClosures[updateType] as List) << handler
		else
			handlersClosures[updateType] = [handler]
	}

	void on(String updateType, @DelegatesTo(MethodsContext) Closure handler) {
		def type = UpdateType.fromString(updateType)

		if (handlersClosures.containsKey(type))
			(handlersClosures[type] as List) << handler
		else
			handlersClosures[type] = [handler]
	}

	@Override
	void onUpdate(@DelegatesTo(MethodsContext) Closure handler) {
		(handlersClosures[UpdateType.UPDATE] as List).add(handler)
	}

	@Override
	void onCommand(String command, @DelegatesTo(MethodsContext) Closure handler) {
		(handlersClosures[UpdateType.MESSAGE] as Map).put(command.startsWith(commandSymbol) ? command : "$commandSymbol$command", handler)
	}

	@Override
	void onMessage(String message, @DelegatesTo(MethodsContext) Closure handler) {
		(handlersClosures[UpdateType.MESSAGE] as Map).put(message, handler)
	}

	@Override
	void onUpdateHandler(UpdateType updateType, UpdateHandler handler) {
		if (handlersUpdates.containsKey(updateType))
			(handlersUpdates[updateType] as List) << handler
		else
			handlersUpdates[updateType] = [handler]
	}

	void onUpdateHandler(String updateType, UpdateHandler handler) {
		def type = UpdateType.fromString(updateType)

		if (handlersUpdates.containsKey(type))
			(handlersUpdates[type] as List) << handler
		else
			handlersUpdates[type] = [handler]
	}

	@Override
	void onUpdateUpdateHandler(UpdateHandler handler) {
		(handlersUpdates[UpdateType.UPDATE] as List).add(handler)
	}

	@Override
	void onCommandUpdateHandler(String command, UpdateHandler handler) {
		(handlersUpdates[UpdateType.MESSAGE] as Map).put(command.startsWith(commandSymbol) ? command : "$commandSymbol$command", handler)
	}

	@Override
	void onMessageUpdateHandler(String message, UpdateHandler handler) {
		(handlersUpdates[UpdateType.MESSAGE] as Map).put(message, handler)
	}

	void middleware(Closure<Boolean> closure) {
		middles.add(closure)
	}

	@Override
	ObjectMapper getJacksonObjectMapper() {
		this.jacksonObjectMapper
	}
}