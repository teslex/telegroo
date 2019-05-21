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
import tech.teslex.telegroo.api.update.*
import tech.teslex.telegroo.simple.SimpleTelegroo
import tech.teslex.telegroo.simple.context.SimpleCommandContext
import tech.teslex.telegroo.simple.context.SimpleMessageContext
import tech.teslex.telegroo.simple.context.SimpleMethodsContext
import tech.teslex.telegroo.telegram.enums.UpdateType
import tech.teslex.telegroo.telegram.types.MessageEntity
import tech.teslex.telegroo.telegram.types.update.Update

import java.util.regex.Matcher

@CompileStatic
class SimpleUpdateHandlersSolver implements UpdateHandlersSolver {

	private final SimpleTelegroo telegroo

	SimpleUpdateHandlersSolver(SimpleTelegroo telegroo) {
		this.telegroo = telegroo
	}

	@Override
	void solve(List<Update> updates, Map<UpdateType, List<UpdateHandler>> handlers) {
		updates.each { update -> solveOne(update, handlers) }
	}

	@Override
	void solveOne(Update update, Map<UpdateType, List<UpdateHandler>> handlers) {
		telegroo.mainContext.update = update

		handlers.getOrDefault(UpdateType.UPDATE, []).each { handler ->
			handler.handle(new SimpleMethodsContext(telegroo.mainContext.telegramClient, update))
		}

		if (update.updateType == UpdateType.MESSAGE) {

			handlers.getOrDefault(UpdateType.MESSAGE, []).each { handler ->
				if (handler instanceof SimpleUpdateHandler)
					handler.handle(new SimpleMethodsContext(telegroo.mainContext.telegramClient, update))

				if (!update.message.text) return

				if (handler instanceof MessagePatternUpdateHandler) {
					Matcher matcher = update.message.text =~ handler.pattern

					if (matcher.matches()) {
						handler.handle(new SimpleMessageContext(telegroo.mainContext.telegramClient, update, matcher))
						return
					}
				}

				if (handler instanceof EntitiesUpdateHandler && update.message.entities) {
					// handle commands
					if (handler instanceof CommandPatternUpdateHandler && handleCommand(update, handler))
						return

					//handle entities
					if (handleEntities(update, handler))
						return
				}
			}
		} else {
			handlers.getOrDefault(update.updateType, []).each { handler ->
				handler.handle(new SimpleMethodsContext(telegroo.mainContext.telegramClient, update))
			}
		}
	}

	private boolean handleCommand(Update update, CommandPatternUpdateHandler handler) {
		MessageEntity entity = update.message.entities.find {
			it.type == "bot_command"
		}

		if (entity) {
			String command = update.message.text[entity.offset + 1..entity.offset + entity.length - 1]
			String argsText = update.message.text.length() > entity.offset + entity.length ? update.message.text[entity.offset + entity.length + 1..update.message.text.length() - 1] : ""

			Matcher commandMatcher = command =~ handler.pattern

			if (commandMatcher.matches()) {
				Matcher argsMatcher = argsText =~ handler.argsPattern
				handler.handle(new SimpleCommandContext(telegroo.mainContext.telegramClient, update, commandMatcher, argsMatcher, argsText))
				return true
			}
		}

		return false
	}

	private boolean handleEntities(Update update, EntitiesUpdateHandler handler) {
		if (!Collections.disjoint(update.message.entities*.type, handler.entities)) {
			handler.handle(new SimpleMethodsContext(telegroo.mainContext.telegramClient, update))
			return true
		}

		return false
	}
}
