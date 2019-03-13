package tech.teslex.telegroo.simple.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.update.UpdateHandler
import tech.teslex.telegroo.api.update.UpdateHandlersSolver
import tech.teslex.telegroo.simple.SimpleTelegroo
import tech.teslex.telegroo.simple.context.SimpleContext
import tech.teslex.telegroo.telegram.enums.UpdateType
import tech.teslex.telegroo.telegram.types.update.Update

@CompileStatic
class SimpleUpdateHandlersSolver implements UpdateHandlersSolver {

	private SimpleTelegroo telegroo

	SimpleUpdateHandlersSolver(SimpleTelegroo telegroo) {
		this.telegroo = telegroo
	}

	@Override
	def solve(Update update, Map handlers) {
		def context = new SimpleContext(telegroo.api, update)

		handlers[UpdateType.UPDATE].each { UpdateHandler handler ->
			handler.handle([update, context, telegroo] as SimpleUpdateRes)
		}

		if (update.updateType == UpdateType.MESSAGE) {

			def handler = handlers[UpdateType.MESSAGE].find { Map.Entry entry ->
				update.message.text ==~ entry.key
			} as Map.Entry<String, UpdateHandler>

			if (handler) {
				def match = update.message.text =~ handler.key

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
