package tech.teslex.telegroo.api.traits.webhook

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.webhook.DeleteWebhookMethodObject
import tech.teslex.telegroo.telegram.methods.objects.webhook.SetWebhookMethodObject

@CompileStatic
trait DeleteWebhookMethodTrait implements Context {

	TelegramResult<Object> deleteWebhook() {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(new DeleteWebhookMethodObject()).returnContent().asStream(), type)
	}
}