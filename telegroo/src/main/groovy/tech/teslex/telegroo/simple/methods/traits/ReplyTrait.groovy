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

package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.SelfType
import tech.teslex.telegroo.api.TelegramClient
import tech.teslex.telegroo.api.methods.reply.ReplyMethod
import tech.teslex.telegroo.simple.SimpleTelegramClient
import tech.teslex.telegroo.simple.context.SimpleContext
import tech.teslex.telegroo.simple.context.SimpleMethodsContext

@CompileStatic
@SelfType(SimpleContext)
trait ReplyTrait implements ReplyMethod {

	/**
	 * example: reply(12343) { sendMessage(text: 'Nice') }*/
	@Override
	void reply(replyTo, @DelegatesTo(SimpleMethodsContext) Closure closure) {
		TelegramClient client = new SimpleTelegramClient((telegramClient as SimpleTelegramClient).token, ['reply_to_message_id': replyTo])

		closure.delegate = new SimpleMethodsContext(client, update)
		closure()
	}

	/**
	 * example: reply { sendMessage(text: 'Nice') }*/
	@Override
	void reply(@DelegatesTo(SimpleMethodsContext) Closure closure) {
		reply(update[update.updateType.value]['messageId'], closure)
	}

	/**
	 * example: reply().sendMessage(text: 'Nice')
	 * example: reply(34225).sendMessage(text: 'Nice')
	 */
	@Override
	SimpleMethodsContext reply(replyTo = update[update.updateType.value]['messageId']) {
		TelegramClient client = new SimpleTelegramClient((telegramClient as SimpleTelegramClient).token, ['reply_to_message_id': replyTo])

		new SimpleMethodsContext(client, update)
	}
}