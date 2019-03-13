package tech.teslex.telegroo.simple

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Telegroo
import tech.teslex.telegroo.api.update.UpdateHandler
import tech.teslex.telegroo.api.update.UpdateHandlersSolver
import tech.teslex.telegroo.simple.context.SimpleContext
import tech.teslex.telegroo.simple.update.SimpleUpdateHandlersSolver
import tech.teslex.telegroo.telegram.enums.UpdateType
import tech.teslex.telegroo.telegram.types.update.Update

@CompileStatic
class SimpleTelegroo extends SimpleContext implements Telegroo {

	protected String token

	protected Map handlers = [
			(UpdateType.MESSAGE): [:] as Map<String, UpdateHandler>,
			(UpdateType.UPDATE) : [] as List<UpdateHandler>
	]

	protected List<Closure<Boolean>> middles = []

	protected UpdateHandlersSolver updateHandlersSolver

	protected Boolean active = false

	public String commandSymbol = '/'

	private ObjectMapper jacksonObjectMapper

	SimpleTelegroo(String token) {
		super(new SimpleApi(token), new Update(updateId: 0))

		this.token = token
		this.updateHandlersSolver = new SimpleUpdateHandlersSolver(this)
		this.jacksonObjectMapper = new ObjectMapper()
	}

	def start() {
		if (active)
			return

		active = true

		while (active) {
			def updates = getUpdates(offset: lastUpdate.updateId + 1)

			for (update in updates)
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
			updateHandlersSolver.solve(lastUpdate, handlers)
	}

	def onUpdate(UpdateHandler handler) {
		(handlers[UpdateType.UPDATE] as List).add(handler)
	}

	def onCommand(String command, UpdateHandler handler) {
		(handlers[UpdateType.MESSAGE] as Map).put(command.startsWith(commandSymbol) ? command : "$commandSymbol$command", handler)
	}

	def onMessage(String message, UpdateHandler handler) {
		(handlers[UpdateType.MESSAGE] as Map).put(message, handler)
	}

	def on(String updateType, UpdateHandler handler) {
		def type = UpdateType.fromString(updateType)

		if (handlers.containsKey(type))
			(handlers[type] as List) << handler
		else
			handlers[type] = [handler]
	}


	def on(UpdateType updateType, UpdateHandler handler) {
		if (handlers.containsKey(updateType))
			(handlers[updateType] as List) << handler
		else
			handlers[updateType] = [handler]
	}

	def middleware(Closure<Boolean> closure) {
		middles.add(closure)
	}

	@Override
	ObjectMapper getJacksonObjectMapper() {
		this.jacksonObjectMapper
	}
}