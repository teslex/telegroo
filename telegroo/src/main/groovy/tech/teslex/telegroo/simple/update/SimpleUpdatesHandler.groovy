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
import tech.teslex.telegroo.telegram.api.TelegramErrorException
import tech.teslex.telegroo.telegram.api.types.MessageEntity
import tech.teslex.telegroo.telegram.api.types.update.Update
import tech.teslex.telegroo.telegram.enums.UpdateType

import java.util.regex.Matcher

@CompileStatic
class SimpleUpdatesHandler implements UpdatesHandler {

	private final SimpleTelegroo telegroo

	SimpleUpdatesHandler(SimpleTelegroo telegroo) {
		this.telegroo = telegroo
	}

	@Override
	void handle(List<Update> updates, Map<UpdateType, Queue<UpdateListener>> listeners) {
		updates.each { update -> handleOne(update, listeners) }
	}

	@Override
	void handleOne(Update update, Map<UpdateType, Queue<UpdateListener>> listeners) {
		telegroo.mainContext.update = update

		if (!checkMiddleware(update)) return

		listeners.getOrDefault(UpdateType.UPDATE, new LinkedList<UpdateListener>()).each { listener ->
			try {
				listener.handle(new SimpleMethodsContext(telegroo.mainContext.telegramClient, update))
			} catch (TelegramErrorException e) {
				listener.onTelegramError().accept(e)
			}
		}

		if (update.updateType == UpdateType.MESSAGE) {

			listeners.getOrDefault(UpdateType.MESSAGE, new LinkedList<UpdateListener>()).each { listener ->
				try {
					if (listener instanceof SimpleUpdateListener)
						listener.handle(new SimpleMethodsContext(telegroo.mainContext.telegramClient, update))

					if (!update.message.text) return

					if (listener instanceof MessagePatternUpdateListener) {
						Matcher matcher = update.message.text =~ listener.pattern

						if (matcher.matches()) {
							listener.handle(new SimpleMessageContext(telegroo.mainContext.telegramClient, update, matcher))
							return
						}
					}

					if (listener instanceof EntityUpdateListener && update.message.entities) {
						if (listener instanceof CommandUpdateListener) {
							// handle commands
							handleCommand(update, listener)
						} else {
							//handle entities
							handleEntity(update, listener)
						}
					}
				} catch (TelegramErrorException e) {
					listener.onTelegramError().accept(e)
				}
			}
		} else if (update.updateType == UpdateType.CALLBACK_QUERY) {
			listeners.getOrDefault(UpdateType.CALLBACK_QUERY, new LinkedList<UpdateListener>()).each { listener ->
				try {
					if (listener instanceof CallbackQueryUpdateListener)
						handleCallbackQuery(update, listener)
					else
						listener.handle(new SimpleMethodsContext(telegroo.mainContext.telegramClient, update))
				} catch (TelegramErrorException e) {
					listener.onTelegramError().accept(e)
				}
			}
		} else {
			listeners.getOrDefault(update.updateType, new LinkedList<UpdateListener>()).each { listener ->
				try {
					listener.handle(new SimpleMethodsContext(telegroo.mainContext.telegramClient, update))
				} catch (TelegramErrorException e) {
					listener.onTelegramError().accept(e)
				}
			}
		}
	}

	private boolean handleCommand(Update update, CommandUpdateListener handler) {
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

	private boolean handleEntity(Update update, EntityUpdateListener handler) {
		if (update.message.entities.find { it.type.contains(handler.entity) }) {
			handler.handle(new SimpleMethodsContext(telegroo.mainContext.telegramClient, update))
			return true
		}

		return false
	}

	private boolean handleCallbackQuery(Update update, CallbackQueryUpdateListener handler) {
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