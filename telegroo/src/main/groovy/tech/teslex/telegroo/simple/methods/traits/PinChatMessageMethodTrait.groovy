package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.methods.PinChatMessageMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.PinChatMessageMethodObject

@CompileStatic
trait PinChatMessageMethodTrait implements PinChatMessageMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> pinChatMessage(@NamedDelegate PinChatMessageMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> pinChatMessage(Map data) {
		pinChatMessage(data as PinChatMessageMethodObject)
	}

	@Override
	TelegramResult<Object> pinChatMessage(@DelegatesTo(PinChatMessageMethodObject) Closure closure) {
		def builder = PinChatMessageMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		pinChatMessage(builder)
	}
}
