package tech.teslex.telegroo.simple.methods.traits.webhook

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
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.webhook.GetWebhookInfoMethod
import tech.teslex.telegroo.telegram.methods.objects.webhook.GetWebhookInfoMethodObject
import tech.teslex.telegroo.telegram.types.WebhookInfo

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait GetWebhookInfoMethodTrait implements GetWebhookInfoMethod<TelegramResult<WebhookInfo>> {

	@Override
	TelegramResult<WebhookInfo> getWebhookInfo() {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, WebhookInfo)

		objectMapper.readValue(telegramClient.go(new GetWebhookInfoMethodObject()).returnContent().asStream(), type)
	}
}