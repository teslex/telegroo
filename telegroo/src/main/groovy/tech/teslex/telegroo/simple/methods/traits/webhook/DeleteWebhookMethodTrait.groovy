package tech.teslex.telegroo.simple.methods.traits.webhook

import groovy.transform.CompileStatic
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.webhook.DeleteWebhookMethod
import tech.teslex.telegroo.telegram.methods.objects.webhook.DeleteWebhookMethodObject

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait DeleteWebhookMethodTrait implements DeleteWebhookMethod<TelegramResult<Object>> {

	@Override
	TelegramResult<Object> deleteWebhook() {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(new DeleteWebhookMethodObject()).returnContent().asStream(), type)
	}
}