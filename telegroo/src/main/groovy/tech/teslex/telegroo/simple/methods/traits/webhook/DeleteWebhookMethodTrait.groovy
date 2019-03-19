package tech.teslex.telegroo.simple.methods.traits.webhook

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.methods.webhook.DeleteWebhookMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.webhook.DeleteWebhookMethodObject

@CompileStatic
trait DeleteWebhookMethodTrait implements DeleteWebhookMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	TelegramResult<Object> deleteWebhook() {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(new DeleteWebhookMethodObject()).returnContent().asStream(), type)
	}
}