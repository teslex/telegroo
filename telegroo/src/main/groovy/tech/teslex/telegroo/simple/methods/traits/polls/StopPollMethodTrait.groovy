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

package tech.teslex.telegroo.simple.methods.traits.polls

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.SimpleTelegramClient
import tech.teslex.telegroo.simple.context.SimpleContext
import tech.teslex.telegroo.telegram.api.TelegramResult
import tech.teslex.telegroo.telegram.api.methods.interfaces.polls.StopPollMethod
import tech.teslex.telegroo.telegram.api.methods.objects.polls.StopPollMethodObject
import tech.teslex.telegroo.telegram.api.types.Message
import tech.teslex.telegroo.telegram.api.types.Poll

@CompileStatic
@SelfType(SimpleContext)
trait StopPollMethodTrait implements StopPollMethod<TelegramResult<Poll>> {

	@Override
	TelegramResult<Message> stopPoll(Map data) {
		stopPoll(data as StopPollMethodObject)
	}

	@Override
	TelegramResult<Message> stopPoll(@NamedDelegate StopPollMethodObject data) {
		data.chatId = data.chatId ?: update[update.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Poll)

		telegramClient.go(data).handleResponse { SimpleTelegramClient.handleResponse(it, type) }
	}

	@Override
	TelegramResult<Message> stopPoll(@DelegatesTo(value = StopPollMethodObject, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		StopPollMethodObject builder = new StopPollMethodObject()
		closure.delegate = builder
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure.call()
		stopPoll(builder)
	}
}