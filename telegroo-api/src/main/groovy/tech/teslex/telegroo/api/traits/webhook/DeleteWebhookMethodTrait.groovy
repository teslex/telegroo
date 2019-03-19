package tech.teslex.telegroo.api.traits.webhook

import groovy.transform.CompileStatic
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.webhook.DeleteWebhookMethodObject

@CompileStatic
trait DeleteWebhookMethodTrait implements Context<Response> {

	TelegramResult<Object> deleteWebhook() {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(new DeleteWebhookMethodObject()).returnContent().asStream(), type)
	}
}