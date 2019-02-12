package tech.teslex.telegroo.impl.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.update.Update
import tech.teslex.telegroo.api.update.UpdateHandler

@CompileStatic
class TelegrooUpdateHandler implements UpdateHandler {

	@Override
	def handle(Update update, Map handlers) {

		handlers.update.each { Closure closure ->
			closure(update)
		}


		if (update.updateType == 'message') {

			def handler = handlers.message.find { Map.Entry entry ->
				update['message']['text'] ==~ entry.key
			} as Map<Object, Closure>

			if (handler) {
				if (handler.value.maximumNumberOfParameters == 1)
					(handler.value as Closure)([update: update, match: update['message']['text'] =~ handler.key])
				else
					(handler.value as Closure)(update, update['message']['text'] =~ handler.key)
			}
		} else {

			def validHandlers = handlers[update.updateType]

			validHandlers.each { Closure handle ->
				handle.call(update)
			}
		}
	}
}
