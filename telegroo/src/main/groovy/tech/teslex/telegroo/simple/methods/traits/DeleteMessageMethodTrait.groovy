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
import tech.teslex.telegroo.telegram.api.TelegramResult
import tech.teslex.telegroo.telegram.api.methods.interfaces.DeleteMessageMethod
import tech.teslex.telegroo.telegram.api.methods.objects.DeleteMessageMethodObject

@CompileStatic
@SelfType(SimpleContext)
trait DeleteMessageMethodTrait implements DeleteMessageMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> deleteMessage(@NamedDelegate DeleteMessageMethodObject data) {
		data.chatId = data.chatId ?: update[update.updateType.value]['chat']['id']
		data.messageId = data.messageId ?: update[update.updateType.value]['messageId'] as Integer

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		telegramClient.go(data).handleResponse { SimpleTelegramClient.handleResponse(it, type) }
	}

	@Override
	TelegramResult<Object> deleteMessage(Map data) {
		deleteMessage(data as DeleteMessageMethodObject)
	}

	@Override
	TelegramResult<Object> deleteMessage(@DelegatesTo(value = DeleteMessageMethodObject, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		DeleteMessageMethodObject builder = new DeleteMessageMethodObject()
		closure.delegate = builder
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure.call()
		deleteMessage(builder)
	}
}
