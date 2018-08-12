package tech.teslex.telegroo

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Actions
import tech.teslex.telegroo.api.Api

@CompileStatic
class Telegroo implements Bot, Actions {

	String token

	Api api

	Map lastUpdate = [update_id: 0],
		handles = [
				message: [:] as Map<String, Closure>,
				update : [] as List<Closure>
		]

	List<Closure<Boolean>> middles = []

	Closure catchException = { Exception e ->
		e.printStackTrace()
		stop()
	}

	boolean active = false

	Telegroo(String token) {
		this.token = token
		this.api = new Api(token)
	}

	void start() {
		if (active)
			return

		active = true

		while (active) {
			try {
				def updates = getUpdates((lastUpdate['update_id'] as Integer) + 1)['result'] as List

				for (update in updates) {
					lastUpdate = update as Map

					if (checkMid(lastUpdate))
						solveUpdate(lastUpdate)
				}
			} catch (ex) {
				catchException ex
			}
		}
	}

	Thread startAsync() {
		Thread.start {
			start()
		}
	}

	void stop() {
		if (!active)
			return

		active = false
	}

	boolean checkMid(Map update) {
		for (mid in middles)
			if (!mid(update))
				return false

		return true
	}

	void solveUpdate(Map update) {
		handles.update.each { Closure closure ->
			closure(update)
		}

		if (update.keySet()[1] == 'message') {
			def handle = (handles.message as Map).find {
				update['message']['text'] ==~ it.key
			} as Map.Entry<String, Closure>

			if (handle)
				if (handle.value.maximumNumberOfParameters == 1)
					(handle.value as Closure)([update: update, match: update['message']['text'] =~ handle.key])
				else
					(handle.value as Closure)(update, update['message']['text'] =~ handle.key)
		} else {
			def handle = (handles[update.keySet()[1] as String])

			if (handle)
				(handle as Closure)(update)
		}
	}

	void onUpdate(Closure closure) {
		(handles.update as List).add(closure)
	}

	void onCommand(String command, Closure closure) {
		(handles.message as Map).put(command.startsWith('/') ? command : "/$command", closure)
	}

	void onMessage(String message, Closure closure) {
		(handles.message as Map).put(message, closure)
	}

	void on(String type, Closure closure) {
		handles[type] = closure
	}

	void middleware(Closure<Boolean> closure) {
		middles.add(closure)
	}
}