package tech.teslex.telegroo

import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Actions
import tech.teslex.telegroo.api.Api

@CompileStatic
class Telegroo implements Bot, Actions {

	String token = ''

	def lastUpdate = [
	        update_id: 0
	]

	boolean active = false

	Api api

	def handles = [
			message: [:] as Map<String, Closure>,

			update : [] as List<Closure>
	]

	Closure catchException = { Exception ex ->
		ex.printStackTrace()
		stop()
	}

	Telegroo(String token) {
		this.token = token
		this.api = new Api(token)
	}

	@CompileDynamic
	void start() {
		if (active)
			return

		active = true

		while (active) {
			try {
				def updates = getUpdates(lastUpdate.update_id + 1).result as List

				updates.each { update ->

					lastUpdate = update as LinkedHashMap

					handles.update.each {
						it(lastUpdate)
					}

					if (lastUpdate.keySet()[1] == 'message') {

						def handle = handles[lastUpdate.keySet()[1] as String].find {
							lastUpdate.message.text ==~ it.key
						} as Map.Entry<String, Closure>

						if (handle)
							if (handle.value.maximumNumberOfParameters == 1)
								handle.value([lastUpdate: lastUpdate, match: lastUpdate.message.text =~ handle.key])
							else
								handle.value(lastUpdate, lastUpdate.message.text =~ handle.key)
					} else {

						def handle = handles[lastUpdate.keySet()[1] as String]

						if (handle)
							handle(lastUpdate)
					}
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