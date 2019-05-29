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

package tech.teslex.telegroo.simple


import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.update.UpdateListener
import tech.teslex.telegroo.api.update.UpdatesHandler
import tech.teslex.telegroo.simple.context.SimpleMethodsContext
import tech.teslex.telegroo.simple.update.SimpleUpdatesHandler
import tech.teslex.telegroo.telegram.api.TelegramResult
import tech.teslex.telegroo.telegram.enums.UpdateType
import tech.teslex.telegroo.telegram.api.types.update.Update

/**
 * Simple Telegroo implementation
 *
 * Example:
 * ---
 * def bot = new SimpleTelegroo('TOKEN')
 * bot.command(/start/) {*     sendMessage(text: 'Welcome!')
 *}* ---
 */
@CompileStatic
class SimpleTelegroo implements SimpleTelegrooTrait {

	String token

	Map<UpdateType, Queue<UpdateListener>> handlers = [:]

	List<Closure<Boolean>> middlewareList = []

	UpdatesHandler updateHandlersSolver

	boolean active = false

	SimpleMethodsContext mainContext

	SimpleTelegramClient telegramClient

	protected SimpleTelegroo() {}

	SimpleTelegroo(String token) {
		this.token = token
		this.telegramClient = new SimpleTelegramClient(token)
		this.mainContext = new SimpleMethodsContext(telegramClient, new Update(updateId: 0))
		this.updateHandlersSolver = new SimpleUpdatesHandler(this)
	}

	@Override
	void start() {
		if (active)
			return

		active = true

		while (active) {
			TelegramResult<List<Update>> response = mainContext.getUpdates(offset: mainContext.update.updateId + 1)

			if (response && response.ok && response.result)
				solveUpdates(response.result)
		}
	}

	@Override
	void stop() {
		active = false
	}

	@Override
	void solveUpdates(List<Update> updates) {
		updateHandlersSolver.handle(updates, handlers)
	}
}