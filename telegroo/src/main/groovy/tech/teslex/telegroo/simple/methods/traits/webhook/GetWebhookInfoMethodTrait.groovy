package tech.teslex.telegroo.simple.methods.traits.webhook

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.methods.webhook.GetWebhookInfoMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.webhook.GetWebhookInfoMethodObject
import tech.teslex.telegroo.telegram.types.WebhookInfo

@CompileStatic
trait GetWebhookInfoMethodTrait implements GetWebhookInfoMethod<TelegramResult<WebhookInfo>>, ContextWithObjectMapper {

	@Override
	TelegramResult<WebhookInfo> getWebhookInfo() {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, WebhookInfo)

		objectMapper.readValue(api.go(new GetWebhookInfoMethodObject()).returnContent().asStream(), type)
	}
}
