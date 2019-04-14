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

package tech.teslex.telegroo.simple.methods.traits.payments

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.payments.AnswerShippingQueryMethod
import tech.teslex.telegroo.telegram.methods.objects.payments.AnswerShippingQueryMethodObject

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait AnswerShippingQueryMethodTrait implements AnswerShippingQueryMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> answerShippingQuery(@NamedDelegate AnswerShippingQueryMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(telegramClient.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> answerShippingQuery(Map data) {
		answerShippingQuery(data as AnswerShippingQueryMethodObject)
	}

	@Override
	TelegramResult<Object> answerShippingQuery(@DelegatesTo(AnswerShippingQueryMethodObject) Closure closure) {
		AnswerShippingQueryMethodObject builder = new AnswerShippingQueryMethodObject()
		closure.delegate = builder
		closure.call()
		answerShippingQuery(builder)
	}
}
