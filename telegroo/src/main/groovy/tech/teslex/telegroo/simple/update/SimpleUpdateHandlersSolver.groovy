/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * © 2019 TesLex
 */

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

@CompileStatic
class SimpleUpdateHandlersSolver implements UpdateHandlersSolver {

	private SimpleTelegroo telegroo

	SimpleUpdateHandlersSolver(SimpleTelegroo telegroo) {
		this.telegroo = telegroo
	}

	@Override
	void solve(Update update, Map<UpdateType, List<UpdateHandler>> handlers) {

		if (handlers.containsKey(UpdateType.UPDATE)) handlers[UpdateType.UPDATE].each {
			it.handle(new SimpleContext(telegroo.mainContext.telegramClient, update, telegroo.mainContext.objectMapper))
		}

		solveMessagesAndCommands(update, handlers[UpdateType.MESSAGE])

		handlers.findAll { it.key != UpdateType.MESSAGE && it.key != UpdateType.UPDATE }.each {
			it.value.each {
				it.handle(new SimpleContext(telegroo.mainContext.telegramClient, update, telegroo.mainContext.objectMapper))
			}
		}
	}

	private void solveMessagesAndCommands(Update update, List<UpdateHandler> handlers) {
		handlers.each { handler ->
			if (handler instanceof CommandUpdateHandler) {
				def pattern = handler.useCommandSymbol() ? handler.patternWithCommandSymbol : handler.pattern
				if (pattern.matcher(update.message.text)) {
					handler.handle(new SimpleContext(telegroo.mainContext.telegramClient, update, telegroo.mainContext.objectMapper, update.message.text =~ pattern))
				}
			} else if (handler instanceof MessageUpdateHandler) {
				def pattern = handler.pattern
				if (pattern.matcher(update.message.text)) {
					handler.handle(new SimpleContext(telegroo.mainContext.telegramClient, update, telegroo.mainContext.objectMapper, update.message.text =~ pattern))
				}
			} else {
				handler.handle(new SimpleContext(telegroo.mainContext.telegramClient, update, telegroo.mainContext.objectMapper))
			}
		}
	}
}
