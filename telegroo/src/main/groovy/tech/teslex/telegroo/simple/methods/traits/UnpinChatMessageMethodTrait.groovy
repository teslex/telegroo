package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.UnpinChatMessageMethod
import tech.teslex.telegroo.telegram.methods.objects.UnpinChatMessageMethodObject

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait UnpinChatMessageMethodTrait implements UnpinChatMessageMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> unpinChatMessage(@NamedDelegate UnpinChatMessageMethodObject data) {
		data.chatId = data.chatId ?: update[update.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(telegramClient.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> unpinChatMessage(Map data) {
		unpinChatMessage(data as UnpinChatMessageMethodObject)
	}

	@Override
	TelegramResult<Object> unpinChatMessage(@DelegatesTo(UnpinChatMessageMethodObject) Closure closure) {
		UnpinChatMessageMethodObject builder = new UnpinChatMessageMethodObject()
		closure.delegate = builder
		closure.call()
		unpinChatMessage(builder)
	}
}
