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
	def solve(Update update, Map handlersClosures, Map handlersUpdates = [:]) {

		handlersClosures[UpdateType.UPDATE].each { Closure handler ->
			handler.delegate = new SimpleContext(telegroo.api, update)
			handler.call()
		}

		handlersUpdates[UpdateType.UPDATE].each { UpdateHandler handler ->
			handler.handle(new SimpleContext(telegroo.api, update))
		}

		if (update.updateType == UpdateType.MESSAGE) {

			def handlerClosure = handlersClosures[UpdateType.MESSAGE].find { Map.Entry entry ->
				update.message.text ==~ entry.key
			} as Map.Entry<String, Closure>

			def handlerUpdate = handlersUpdates[UpdateType.MESSAGE].find { Map.Entry entry ->
				update.message.text ==~ entry.key
			} as Map.Entry<String, UpdateHandler>

			if (handlerClosure) {
				def match = update.message.text =~ handlerClosure.key
				def handlerClosureEntry = handlerClosure.value

				handlerClosureEntry.delegate = new SimpleContext(telegroo.api, update, match)
				handlerClosureEntry.call()
			}

			if (handlerUpdate) {
				def match = update.message.text =~ handlerUpdate.key
				def handlerUpdateEntry = handlerUpdate.value

				handlerUpdateEntry.handle(new SimpleContext(telegroo.api, update, match))
			}
		} else {

			def validHandlersClosures = handlersClosures[update.updateType]
			def validHandlersUpdates = handlersUpdates[update.updateType]

			validHandlersClosures.each { Closure handler ->
				handler.delegate = new SimpleContext(telegroo.api, update)
				handler.call()
			}

			validHandlersUpdates.each { UpdateHandler handler ->
				handler.handle(new SimpleContext(telegroo.api, update))
			}
		}
	}
}
