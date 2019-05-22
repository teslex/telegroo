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
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.SimpleTelegramClient
import tech.teslex.telegroo.simple.context.SimpleContext
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.SetChatDescriptionMethod
import tech.teslex.telegroo.telegram.methods.objects.SetChatDescriptionMethodObject

@CompileStatic
@SelfType(SimpleContext)
trait SetChatDescriptionMethodTrait implements SetChatDescriptionMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> setChatDescription(@NamedDelegate SetChatDescriptionMethodObject data) {
		data.chatId = data.chatId ?: update[update.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		telegramClient.go(data).handleResponse { SimpleTelegramClient.handleResponse(it, type) }
	}

	@Override
	TelegramResult<Object> setChatDescription(Map data) {
		setChatDescription(data as SetChatDescriptionMethodObject)
	}

	@Override
	TelegramResult<Object> setChatDescription(@DelegatesTo(value = SetChatDescriptionMethodObject, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		SetChatDescriptionMethodObject builder = new SetChatDescriptionMethodObject()
		closure.delegate = builder
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure.call()
		setChatDescription(builder)
	}
}
