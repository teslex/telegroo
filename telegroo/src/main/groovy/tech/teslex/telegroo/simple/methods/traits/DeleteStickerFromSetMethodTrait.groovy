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
import tech.teslex.telegroo.telegram.methods.interfaces.DeleteStickerFromSetMethod
import tech.teslex.telegroo.telegram.methods.objects.DeleteStickerFromSetMethodObject

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait DeleteStickerFromSetMethodTrait implements DeleteStickerFromSetMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> deleteStickerFromSet(@NamedDelegate DeleteStickerFromSetMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(telegramClient.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> deleteStickerFromSet(Map data) {
		deleteStickerFromSet(data as DeleteStickerFromSetMethodObject)
	}

	@Override
	TelegramResult<Object> deleteStickerFromSet(@DelegatesTo(DeleteStickerFromSetMethodObject) Closure closure) {
		DeleteStickerFromSetMethodObject builder = new DeleteStickerFromSetMethodObject()
		closure.delegate = builder
		closure.call()
		deleteStickerFromSet(builder)
	}
}
