package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.SendChatActionMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SendChatActionMethodObject

@CompileStatic
trait SendChatActionMethodTrait implements SendChatActionMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> sendChatAction(@NamedDelegate SendChatActionMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> sendChatAction(Map data) {
		sendChatAction(data as SendChatActionMethodObject)
	}

	@Override
	TelegramResult<Object> sendChatAction(@DelegatesTo(SendChatActionMethodObject) Closure closure) {
		def builder = SendChatActionMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		sendChatAction(builder)
	}
}