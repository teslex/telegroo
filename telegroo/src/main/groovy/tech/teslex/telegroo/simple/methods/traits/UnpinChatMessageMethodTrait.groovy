package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.UnpinChatMessageMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.UnpinChatMessageMethodObject

@CompileStatic
trait UnpinChatMessageMethodTrait implements UnpinChatMessageMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> unpinChatMessage(@NamedDelegate UnpinChatMessageMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> unpinChatMessage(Map data) {
		unpinChatMessage(data as UnpinChatMessageMethodObject)
	}

	@Override
	TelegramResult<Object> unpinChatMessage(@DelegatesTo(UnpinChatMessageMethodObject) Closure closure) {
		def builder = UnpinChatMessageMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		unpinChatMessage(builder)
	}
}
