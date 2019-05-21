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
import tech.teslex.telegroo.api.context.CommandContext
import tech.teslex.telegroo.telegram.types.update.Update

import java.util.regex.Matcher

@CompileStatic
class SimpleCommandContext extends SimpleMethodsContext implements CommandContext<TelegramClient<Response>> {

	private final Matcher matcher

	private final Matcher argsMatcher

	private final String argsText

	SimpleCommandContext(TelegramClient<Response> telegramClient, Update lastUpdate, Matcher matcher, Matcher argsMatcher, String argsText) {
		super(telegramClient, lastUpdate)
		this.matcher = matcher
		this.argsMatcher = argsMatcher
		this.argsText = argsText
	}

	@Override
	Matcher getMatcher() {
		this.matcher
	}

	@Override
	Matcher getArgsMatcher() {
		this.argsMatcher
	}

	@Override
	String getArgsText() {
		this.argsText
	}
}
