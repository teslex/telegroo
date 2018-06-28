package tech.teslex.telegroo

import tech.teslex.telegroo.api.Api
import tech.teslex.telegroo.api.Actions

class Telegroo implements Bot, Actions {

	String token = ''

	int offset = -1

	def lastUpdate = [:]

	boolean active = false

	Api api

	Telegroo(String token) {
		this.token = token
		this.api = new Api(token)
	}

	def handles = [
			message: [:],

			update : []
	]

	def catchException = { Exception ex ->
		ex.printStackTrace()
		stop()
	}

	void start() {
		if (active)
			return

		active = true

		while (active) {
			try {
				def updates = api.go('getUpdates', [offset: offset + 1]).result as List

				if (!updates.isEmpty()) {
					updates.each { update ->
						lastUpdate = update

						if (update.keySet()[1] == 'message') {
							def handle = handles[update.keySet()[1] as String].find { update.message.text ==~ it.key }

							if (handle)
								if (handle.value.maximumNumberOfParameters == 1)
									handle.value([update: update, match: update.message.text =~ handle.key ])
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

	def startAsync() {
		Thread.start {
			start()
		}
	}

	void stop() {
		if (!active)
			return

		active = false
	}

	void onUpdate(Closure closure) {
		handles.update.add(closure)
	}

	void onCommand(String command, Closure closure) {
		handles.message.put(command.startsWith('/') ? command : "/$command", closure)
	}

	void onMessage(String message, Closure closure) {
		handles.message.put(message, closure)
	}

	def on(String type, Closure closure) {
		handles[type] = closure
	}
}