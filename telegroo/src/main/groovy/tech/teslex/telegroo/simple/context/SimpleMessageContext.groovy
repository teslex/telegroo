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

import groovy.transform.CompileStatic
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.TelegramClient
import tech.teslex.telegroo.api.context.MessageContext
import tech.teslex.telegroo.telegram.types.update.Update

import java.util.regex.Matcher

@CompileStatic
class SimpleMessageContext extends SimpleMethodsContext implements MessageContext<TelegramClient<Response>> {

	private final Matcher matcher

	SimpleMessageContext(TelegramClient<Response> telegramClient, Update lastUpdate, Matcher matcher) {
		super(telegramClient, lastUpdate)
		this.matcher = matcher
	}

	@Override
	Matcher getMatcher() {
		this.matcher
	}
}