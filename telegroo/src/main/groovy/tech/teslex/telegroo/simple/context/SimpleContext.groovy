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

package tech.teslex.telegroo.simple.context

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.transform.CompileStatic
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.TelegramClient
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.simple.jackson.JacksonObjectMapper
import tech.teslex.telegroo.telegram.api.types.update.Update

/**
 * Simple Context implementation
 */
@CompileStatic
abstract class SimpleContext implements Context<TelegramClient<Response>> {

	private TelegramClient<Response> telegramClient

	private Update lastUpdate

	SimpleContext(TelegramClient<Response> telegramClient, Update lastUpdate) {
		this.telegramClient = telegramClient
		this.lastUpdate = lastUpdate
	}

	@Override
	TelegramClient<Response> getTelegramClient() {
		this.telegramClient
	}

	@Override
	void setTelegramClient(TelegramClient<Response> api) {
		this.telegramClient = api
	}

	@Override
	Update getUpdate() {
		this.lastUpdate
	}

	@Override
	void setUpdate(Update update) {
		this.lastUpdate = update
	}

	static ObjectMapper getObjectMapper() {
		JacksonObjectMapper.objectMapper
	}

	@Override
	Context createNewContext(TelegramClient<Response> telegramClient, Update update) {
		new SimpleMethodsContext(telegramClient, update)
	}
}
