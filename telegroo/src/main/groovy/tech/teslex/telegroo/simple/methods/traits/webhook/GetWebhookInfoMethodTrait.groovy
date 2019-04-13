package tech.teslex.telegroo.simple.methods.traits.webhook

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