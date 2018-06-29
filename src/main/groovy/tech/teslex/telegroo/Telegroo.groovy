package tech.teslex.telegroo

import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Actions
import tech.teslex.telegroo.api.Api

@CompileStatic
class Telegroo implements Bot, Actions {

	String token = ''

	int offset = -1

	LinkedHashMap lastUpdate = [:]

	boolean active = false

	Api api

	Telegroo(String token) {
		this.token = token
		this.api = new Api(token)
	}

	LinkedHashMap<String, Object> handles = [
			message: [:],

			update : []
	]

	Closure catchException = { Exception ex ->
		ex.printStackTrace()
		stop()
	}

	@CompileDynamic
	void start() {
		if (active)
			return

		active = true

		while (active) {
			try {
				def updates = api.go('getUpdates', [offset: offset + 1]).result as List

				if (!updates.isEmpty()) {
					updates.each { update ->
						update = update as LinkedHashMap
						lastUpdate = update

						if (update.keySet()[1] == 'message') {
							def handle = handles[update.keySet()[1] as String].find { update.message.text ==~ it.key }

							if (handle)
								if (handle.value.maximumNumberOfParameters == 1)
									handle.value([update: update, match: update.message.text =~ handle.key])
								else
									handle.value(update, update.message.text =~ handle.key)
						} else {
							def handle = handles[update.keySet()[1] as String]

							if (handle)
								handle(update)
						}
					}

					updates.each { update ->
						handles.update.each {
							it(update)
						}
					}

					offset = updates.last().update_id
				}
			} catch (Exception ex) {
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

	@CompileDynamic
	void onUpdate(Closure closure) {
		handles.update.add(closure)
	}

	@CompileDynamic
	void onCommand(String command, Closure closure) {
		handles.message.put(command.startsWith('/') ? command : "/$command", closure)
	}

	@CompileDynamic
	void onMessage(String message, Closure closure) {
		handles.message.put(message, closure)
	}

	void on(String type, Closure closure) {
		handles[type] = closure
	}
}