package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.LeaveChatMethod
import tech.teslex.telegroo.telegram.methods.objects.LeaveChatMethodObject

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait LeaveChatMethodTrait implements LeaveChatMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> leaveChat(@NamedDelegate LeaveChatMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> leaveChat(Map data) {
		leaveChat(data as LeaveChatMethodObject)
	}

	@Override
	TelegramResult<Object> leaveChat(@DelegatesTo(LeaveChatMethodObject) Closure closure) {
		LeaveChatMethodObject builder = new LeaveChatMethodObject()
		closure.delegate = builder
		closure.call()
		leaveChat(builder)
	}
}
