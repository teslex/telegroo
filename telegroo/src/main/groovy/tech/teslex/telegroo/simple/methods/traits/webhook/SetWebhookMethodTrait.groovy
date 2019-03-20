package tech.teslex.telegroo.simple.methods.traits.webhook

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.webhook.SetWebhookMethod
import tech.teslex.telegroo.telegram.methods.objects.webhook.SetWebhookMethodObject

@CompileStatic
trait SetWebhookMethodTrait implements SetWebhookMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> setWebhook(@NamedDelegate SetWebhookMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> setWebhook(Map data) {
		setWebhook(data as SetWebhookMethodObject)
	}

	@Override
	TelegramResult<Object> setWebhook(@DelegatesTo(SetWebhookMethodObject) Closure closure) {
		def builder = SetWebhookMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		setWebhook(builder)
	}
}