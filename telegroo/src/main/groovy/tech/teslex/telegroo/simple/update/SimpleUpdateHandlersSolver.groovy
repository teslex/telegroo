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
	void solve(List<Update> updates, Map<UpdateType, Queue<UpdateHandler>> handlers) {
		updates.each { update -> solveOne(update, handlers) }
	}

	@Override
	void solveOne(Update update, Map<UpdateType, Queue<UpdateHandler>> handlers) {
		telegroo.mainContext.update = update

		if (!checkMiddleware(update)) return

		handlers.getOrDefault(UpdateType.UPDATE, new LinkedList<UpdateHandler>()).each { handler ->
			handler.handle(new SimpleMethodsContext(telegroo.mainContext.telegramClient, update))
		}

		if (update.updateType == UpdateType.MESSAGE) {

			handlers.getOrDefault(UpdateType.MESSAGE, new LinkedList<UpdateHandler>()).each { handler ->
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
		} else if (update.updateType == UpdateType.CALLBACK_QUERY) {
			handlers.getOrDefault(UpdateType.CALLBACK_QUERY, new LinkedList<UpdateHandler>()).each { handler ->
				if (handler instanceof CallbackQueryUpdateHandler)
					handleCallbackQuery(update, handler)
				else
					handler.handle(new SimpleMethodsContext(telegroo.mainContext.telegramClient, update))
			}
		} else {
			handlers.getOrDefault(update.updateType, new LinkedList<UpdateHandler>()).each { handler ->
				handler.handle(new SimpleMethodsContext(telegroo.mainContext.telegramClient, update))
			}
		}
	}

	private boolean handleCommand(Update update, CommandPatternUpdateHandler handler) {
		MessageEntity entity = update.message.entities.find {
			it.type == "bot_command"
		}

		if (entity) {
			String command = update.message.text.substring(entity.offset + 1, entity.offset + entity.length)

			String argsText = ""
			if (update.message.text.length() > entity.length + entity.offset)
				if (update.message.text[entity.length + entity.offset] == ' ')
					argsText = update.message.text.substring(entity.length + entity.offset + 1, update.message.text.length())
				else
					argsText = update.message.text.substring(entity.length + entity.offset, update.message.text.length())

			Matcher commandMatcher = command =~ handler.pattern

			if (commandMatcher.matches()) {
				if (handler.argsPattern == null) {
					handler.handle(new SimpleCommandContext(telegroo.mainContext.telegramClient, update, commandMatcher, null, argsText))
					return true
				} else {
					Matcher argsMatcher = argsText =~ handler.argsPattern

					if (argsMatcher.matches())
						handler.handle(new SimpleCommandContext(telegroo.mainContext.telegramClient, update, commandMatcher, argsMatcher, argsText))
					return true
				}
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

	private boolean handleCallbackQuery(Update update, CallbackQueryUpdateHandler handler) {
		if (handler.callbackData.contains(update.callbackQuery.data)) {
			handler.handle(new SimpleMethodsContext(telegroo.mainContext.telegramClient, update))
			return true
		}

		return false
	}

	private boolean checkMiddleware(Update update) {
		for (middleware in telegroo.middlewareList)
			if (!middleware(update))
				return false

		return true
	}

}
