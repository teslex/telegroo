package tech.teslex.telegroo.simple.methods.traits.webhook

import groovy.transform.CompileStatic
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.webhook.GetWebhookInfoMethodObject
import tech.teslex.telegroo.telegram.types.WebhookInfo

@CompileStatic
trait GetWebhookInfoMethodTrait implements Context<Response> {

	TelegramResult<WebhookInfo> getWebhookInfo() {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, WebhookInfo)

		jacksonObjectMapper.readValue(api.go(new GetWebhookInfoMethodObject()).returnContent().asStream(), type)
	}
}
