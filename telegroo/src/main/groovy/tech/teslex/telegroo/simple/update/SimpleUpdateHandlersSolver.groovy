package tech.teslex.telegroo.simple.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.update.CommandUpdateHandler
import tech.teslex.telegroo.api.update.MessageUpdateHandler
import tech.teslex.telegroo.api.update.UpdateHandler
import tech.teslex.telegroo.api.update.UpdateHandlersSolver
import tech.teslex.telegroo.simple.SimpleTelegroo
import tech.teslex.telegroo.simple.context.SimpleContext
import tech.teslex.telegroo.telegram.enums.UpdateType
import tech.teslex.telegroo.telegram.types.update.Update

import java.util.regex.Pattern

@CompileStatic
class SimpleUpdateHandlersSolver implements UpdateHandlersSolver {

	private SimpleTelegroo telegroo

	SimpleUpdateHandlersSolver(SimpleTelegroo telegroo) {
		this.telegroo = telegroo
	}

	@Override
	void solve(Update update, List<UpdateHandler> handlers) {

		handlers.findAll { it.type == UpdateType.UPDATE }.each {
			it.handle(new SimpleContext(telegroo.api, update, telegroo.objectMapper))
		}

		if (update.updateType == UpdateType.MESSAGE) {
			def handler = handlers.find {
				if (it instanceof CommandUpdateHandler) {
					((it as CommandUpdateHandler).useCommandSymbol() ? Pattern.compile("${(it as CommandUpdateHandler).commandSymbol}${it.pattern}") : it.pattern).matcher(update.message.text)
				} else if (it instanceof MessageUpdateHandler) {
					(it as MessageUpdateHandler).pattern.matcher(update.message.text)
				} else {
					false
				}
			}

			if (handler) {
				if (handler instanceof CommandUpdateHandler) {
					def pattern = (handler as CommandUpdateHandler).useCommandSymbol() ? "${(handler as CommandUpdateHandler).commandSymbol}${(handler as CommandUpdateHandler).pattern}" : (handler as CommandUpdateHandler).pattern
					handler.handle(new SimpleContext(telegroo.api, update, telegroo.objectMapper, update.message.text =~ pattern))
				} else {
					handler.handle(new SimpleContext(telegroo.api, update, telegroo.objectMapper, update.message.text =~ (handler as MessageUpdateHandler).pattern))
				}
			}
		} else {

			handlers.findAll { it.type == update.updateType }.each {
				it.handle(new SimpleContext(telegroo.api, update, telegroo.objectMapper))
			}
		}
	}
}
