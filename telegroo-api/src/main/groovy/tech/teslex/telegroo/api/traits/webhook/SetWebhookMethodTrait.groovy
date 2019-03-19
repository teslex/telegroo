package tech.teslex.telegroo.api.traits.webhook

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.webhook.SetWebhookMethodObject

@CompileStatic
trait SetWebhookMethodTrait implements Context<Response> {

	@NamedVariant
	TelegramResult<Object> setWebhook(@NamedDelegate SetWebhookMethodObject data) {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> setWebhook(Map data) {
		setWebhook(data as SetWebhookMethodObject)
	}

	TelegramResult<Object> setWebhook(@DelegatesTo(SetWebhookMethodObject) Closure closure) {
		def builder = SetWebhookMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		setWebhook(builder)
	}
}
