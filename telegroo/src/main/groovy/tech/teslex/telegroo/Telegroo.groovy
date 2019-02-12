package tech.teslex.telegroo


import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Api
import tech.teslex.telegroo.api.update.Update
import tech.teslex.telegroo.api.update.UpdateHandler
import tech.teslex.telegroo.impl.Actions
import tech.teslex.telegroo.impl.TelegrooApi
import tech.teslex.telegroo.impl.update.TelegrooUpdate
import tech.teslex.telegroo.impl.update.TelegrooUpdateHandler

@CompileStatic
class Telegroo implements Actions {

	String token

	Api api

	Map handlers = [
			message: [:] as Map<String, Closure>,
			update : [] as List<Closure>
	]

	List<Closure<Boolean>> middles = []

	boolean active = false

	Update lastUpdate

	UpdateHandler updateHandler

	Telegroo(String token) {
		this.token = token

		this.api = new TelegrooApi(token)
		this.updateHandler = new TelegrooUpdateHandler()
		this.lastUpdate = [update_id: 0] as TelegrooUpdate
	}

	void start() {
		if (active)
			return

		active = true

		while (active) {
			def updates = getUpdates((lastUpdate.updateData['update_id'] as Integer) + 1)['result'] as List<Map>

			for (update in updates)
				solve(update as TelegrooUpdate) // new TelegrooUpdate(update)
		}
	}

	void stop() {
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

	void onUpdate(Closure closure) {
		(handlers.update as List).add(closure)
	}

	void onCommand(String command, Closure closure) {
		(handlers.message as Map).put(command.startsWith('/') ? command : "/$command", closure)
	}

	void onMessage(String message, Closure closure) {
		(handlers.message as Map).put(message, closure)
	}

	void on(String type, Closure closure) {
		handlers[type] = closure
	}

	void middleware(Closure<Boolean> closure) {
		middles.add(closure)
	}
}