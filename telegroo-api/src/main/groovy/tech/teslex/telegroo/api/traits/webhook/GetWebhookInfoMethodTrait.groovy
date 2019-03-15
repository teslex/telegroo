package tech.teslex.telegroo.api.traits.webhook

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.webhook.DeleteWebhookMethodObject
import tech.teslex.telegroo.telegram.methods.objects.webhook.GetWebhookInfoMethodObject
import tech.teslex.telegroo.telegram.types.WebhookInfo

@CompileStatic
trait GetWebhookInfoMethodTrait implements Context {

	TelegramResult<WebhookInfo> getWebhookInfo() {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, WebhookInfo)

		jacksonObjectMapper.readValue(api.go(new GetWebhookInfoMethodObject()).returnContent().asStream(), type)
	}
}
