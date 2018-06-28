package tech.teslex.telegroo

import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Api

@CompileStatic
class Telegroo implements Bot {

	String token = ''

	int offset = -1

	boolean active = false

	Api api

	Telegroo(String token) {
		this.token = token
		api = new Api(token)
	}

	def handles = [
			message: [:],

			update : []
	]

	def catchException = { Exception ex ->
		ex.printStackTrace()
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
						if (update.keySet()[1] == 'message') {
							def handle = handles[update.keySet()[1] as String].find { update.message.text ==~ it.key }

							if (handle) {
								handle.value(update, handle.key =~ update.message.text)
							}
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

	def sendMessage(def chatId, String message, Map params = [:]) {
		api.go('sendMessage', [chat_id: chatId, text: message] + params)
	}

	def forwardMessage(def chatId, def fromChatId, def messageId, Map params = [:]) {
		api.go('sendMessage', [chat_id: chatId, from_chat_id: fromChatId, message_id: messageId] + params)
	}

	def on(String type, Closure closure) {
		handles[type] = closure
	}
}