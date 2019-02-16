package tech.teslex.telegroo.simple

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Api
import tech.teslex.telegroo.api.Context
import tech.teslex.telegroo.api.Telegroo
import tech.teslex.telegroo.api.enums.UpdateType
import tech.teslex.telegroo.api.res.UpdateResolver
import tech.teslex.telegroo.api.update.Update
import tech.teslex.telegroo.api.update.UpdateHandler
import tech.teslex.telegroo.simple.update.SimpleUpdate
import tech.teslex.telegroo.simple.update.SimpleUpdateHandler

@CompileStatic
class SimpleTelegroo implements Telegroo, Context {

	String token

	Api api

	Map handlers = [
			message: [:] as Map<String, UpdateResolver>,
			update : [] as List<UpdateResolver>
	]

	List<Closure<Boolean>> middles = []

	Update lastUpdate

	UpdateHandler updateHandler

	boolean active = false

	String commandSymbol = '/'


	SimpleTelegroo(String token) {
		this.token = token

		this.api = new SimpleApi(token)
		this.updateHandler = new SimpleUpdateHandler(this)
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
			updateHandler.handle(lastUpdate, handlers)
	}

	def onUpdate(UpdateResolver resolver) {
		(handlers.update as List).add(resolver)
	}

	def onCommand(String command, UpdateResolver resolver) {
		(handlers.message as Map).put(command.startsWith(commandSymbol) ? command : "$commandSymbol$command", resolver)
	}

	def onMessage(String message, UpdateResolver resolver) {
		(handlers.message as Map).put(message, resolver)
	}

	def on(String type, UpdateResolver resolver) {
		if (handlers.containsKey(type))
			(handlers[type] as List) << resolver
		else
			handlers[type] = [resolver]
	}


	def on(UpdateType updateType, UpdateResolver resolver) {
		String type = updateType.type

		if (handlers.containsKey(type))
			(handlers[type] as List) << resolver
		else
			handlers[type] = [resolver]
	}

	def middleware(Closure<Boolean> closure) {
		middles.add(closure)
	}
}