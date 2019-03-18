package tech.teslex.telegroo.simple.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.update.MessageUpdateHandler
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
	void solve(Update update, List<UpdateHandler> handlers) {

		handlers.findAll { it.type == UpdateType.UPDATE }.each {
			it.handle(new SimpleContext(telegroo.api, update))
		}

		if (update.updateType == UpdateType.MESSAGE) {

			MessageUpdateHandler handler = handlers
					.findAll { it instanceof MessageUpdateHandler }
					.find { update.message.text ==~ (it as MessageUpdateHandler).pattern } as MessageUpdateHandler

			if (handler) {
				handler.handle(new SimpleContext(telegroo.api, update, update.message.text =~ handler.pattern))
			}
		} else {

			handlers.findAll { it.type == update.updateType }.each {
				it.handle(new SimpleContext(telegroo.api, update))
			}
		}
	}
}
