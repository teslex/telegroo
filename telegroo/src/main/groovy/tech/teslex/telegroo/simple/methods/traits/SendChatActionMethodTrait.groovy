package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.SendChatActionMethod
import tech.teslex.telegroo.telegram.methods.objects.SendChatActionMethodObject

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait SendChatActionMethodTrait implements SendChatActionMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> sendChatAction(@NamedDelegate SendChatActionMethodObject data) {
		data.chatId = data.chatId ?: update[update.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(telegramClient.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> sendChatAction(Map data) {
		sendChatAction(data as SendChatActionMethodObject)
	}

	@Override
	TelegramResult<Object> sendChatAction(@DelegatesTo(SendChatActionMethodObject) Closure closure) {
		SendChatActionMethodObject builder = new SendChatActionMethodObject()
		closure.delegate = builder
		closure.call()
		sendChatAction(builder)
	}
}
