package tech.teslex.telegroo.simple.methods.traits

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

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.EditMessageMediaMethod
import tech.teslex.telegroo.telegram.methods.objects.EditMessageMediaMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait EditMessageMediaMethodTrait implements EditMessageMediaMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> editMessageMedia(@NamedDelegate EditMessageMediaMethodObject data) {
		data.chatId = data.chatId ?: update[update.updateType.value]['chat']['id']
		data.messageId = data.messageId ?: update[update.updateType.value]['messageId'] as Integer

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(telegramClient.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> editMessageMedia(Map data) {
		editMessageMedia(data as EditMessageMediaMethodObject)
	}

	@Override
	TelegramResult<Object> editMessageMedia(@DelegatesTo(EditMessageMediaMethodObject) Closure closure) {
		EditMessageMediaMethodObject builder = new EditMessageMediaMethodObject()
		closure.delegate = builder
		closure.call()
		editMessageMedia(builder)
	}
}
