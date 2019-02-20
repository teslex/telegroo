package tech.teslex.telegroo.simple.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.update.Update
import tech.teslex.telegroo.api.update.UpdateHandler
import tech.teslex.telegroo.api.update.UpdateHandlersSolver
import tech.teslex.telegroo.simple.SimpleContext
import tech.teslex.telegroo.simple.SimpleTelegroo

@CompileStatic
class SimpleUpdateHandlersSolver implements UpdateHandlersSolver {

	private SimpleTelegroo telegroo

	SimpleUpdateHandlersSolver(SimpleTelegroo telegroo) {
		this.telegroo = telegroo
	}

	@Override
	def solve(Update update, Map handlers) {
		def context = new SimpleContext(telegroo.api, update)

		handlers.update.each { UpdateHandler handler ->
			handler.handle([update, context, telegroo] as SimpleUpdateRes)
		}

		if (update.updateType == 'message') {

			def handler = handlers['message'].find { Map.Entry entry ->
				update.updateData['message']['text'] ==~ entry.key
			} as Map.Entry<String, UpdateHandler>

			if (handler) {
				def match = update.updateData['message']['text'] =~ handler.key

				handler.value.handle([update, context, match, telegroo] as SimpleUpdateRes)
			}
		} else {

			def validHandlers = handlers[update.updateType]

			validHandlers.each { UpdateHandler handler ->
				handler.handle([update, context, telegroo] as SimpleUpdateRes)
			}
		}
	}
}
