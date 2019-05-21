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

package tech.teslex.telegroo.simple.methods.traits.webhook

import groovy.transform.CompileStatic
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.SimpleContext
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.webhook.DeleteWebhookMethod
import tech.teslex.telegroo.telegram.methods.objects.webhook.DeleteWebhookMethodObject

@CompileStatic
@SelfType(SimpleContext)
trait DeleteWebhookMethodTrait implements DeleteWebhookMethod<TelegramResult<Object>> {

	@Override
	TelegramResult<Object> deleteWebhook() {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(telegramClient.go(new DeleteWebhookMethodObject()).returnContent().asStream(), type)
	}
}