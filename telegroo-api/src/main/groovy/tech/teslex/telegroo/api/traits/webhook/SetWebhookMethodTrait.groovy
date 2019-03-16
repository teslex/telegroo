package tech.teslex.telegroo.api.traits.webhook

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.builders.webhook.SetWebhookMethodObjectBuilder
import tech.teslex.telegroo.telegram.methods.objects.webhook.SetWebhookMethodObject

@CompileStatic
trait SetWebhookMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Object> setWebhook(@NamedDelegate SetWebhookMethodObject data) {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> setWebhook(Map data) {
		setWebhook(data as SetWebhookMethodObject)
	}

	TelegramResult<Object> setWebhook(@DelegatesTo(SetWebhookMethodObjectBuilder) Closure closure) {
		def builder = new SetWebhookMethodObjectBuilder()
		closure.delegate = builder
		closure.call()
		setWebhook(builder.build())
	}
}
