package tech.teslex.telegroo.simple

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Api
import tech.teslex.telegroo.api.Context
import tech.teslex.telegroo.api.Telegroo
import tech.teslex.telegroo.api.enums.UpdateType
import tech.teslex.telegroo.api.update.*
import tech.teslex.telegroo.simple.update.SimpleUpdate
import tech.teslex.telegroo.simple.update.SimpleUpdateHandlersSolver

@CompileStatic
class SimpleTelegroo implements Telegroo, Context {

	String token

	Api api

	Map handlers = [
			message: [:] as Map<String, UpdateHandler>,
			update : [] as List<UpdateHandler>
	]

	List<Closure<Boolean>> middles = []

	Update lastUpdate

	UpdateHandlersSolver updateHandlersSolver

	boolean active = false

	String commandSymbol = '/'


	SimpleTelegroo(String token) {
		this.token = token

		this.api = new SimpleApi(token)
		this.updateHandlersSolver = new SimpleUpdateHandlersSolver(this)
		this.lastUpdate = [update_id: 0] as SimpleUpdate
	}

	def start() {
		if (active)
			return

		active = true

		while (active) {
			def updates = getUpdates((lastUpdate.updateData['update_id'] as Integer) + 1)['result'] as List<Map>

			for (update in updates)
				solve(update as SimpleUpdate)
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
		(handlers.update as List).add(handler)
	}

	def onCommand(String command, CommandHandler handler) {
		(handlers.message as Map).put(command.startsWith(commandSymbol) ? command : "$commandSymbol$command", handler)
	}

	def onMessage(String message, MessageHandler handler) {
		(handlers.message as Map).put(message, handler)
	}

	def on(String type, UpdateHandler handler) {
		if (handlers.containsKey(type))
			(handlers[type] as List) << handler
		else
			handlers[type] = [handler]
	}


	def on(UpdateType updateType, UpdateHandler handler) {
		String type = updateType.type

		if (handlers.containsKey(type))
			(handlers[type] as List) << handler
		else
			handlers[type] = [handler]
	}

	def middleware(Closure<Boolean> closure) {
		middles.add(closure)
	}
}