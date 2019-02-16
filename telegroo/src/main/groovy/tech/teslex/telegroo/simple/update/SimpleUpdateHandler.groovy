package tech.teslex.telegroo.simple.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.simple.SimpleContext
import tech.teslex.telegroo.simple.SimpleTelegroo
import tech.teslex.telegroo.api.res.UpdateResolver
import tech.teslex.telegroo.api.update.Update
import tech.teslex.telegroo.api.update.UpdateHandler
import tech.teslex.telegroo.simple.res.SimpleRes

@CompileStatic
class SimpleUpdateHandler implements UpdateHandler {

	private SimpleTelegroo telegroo

	SimpleUpdateHandler(SimpleTelegroo telegroo) {
		this.telegroo = telegroo
	}

	@Override
	def handle(Update update, Map handlers) {
		def context = new SimpleContext(telegroo.api, update)

		handlers.update.each { UpdateResolver resolver ->
			resolver.resolve([update, context, telegroo] as SimpleRes)
		}

		if (update.updateType == 'message') {

			def handler = handlers['message'].find { Map.Entry entry ->
				update.updateData['message']['text'] ==~ entry.key
			} as Map.Entry<String, UpdateResolver>

			if (handler) {
				def match = update.updateData['message']['text'] =~ handler.key

				handler.value.resolve([update, context, match, telegroo] as SimpleRes)
			}
		} else {

			def validHandlers = handlers[update.updateType]

			validHandlers.each { UpdateResolver resolver ->
				resolver.resolve([update, context, telegroo] as SimpleRes)
			}
		}
	}
}
