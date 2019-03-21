package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.GetChatMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.GetChatMethodObject
import tech.teslex.telegroo.telegram.types.Chat

@CompileStatic
trait GetChatMethodTrait implements GetChatMethod<TelegramResult<Chat>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Chat> getChat(@NamedDelegate GetChatMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Chat)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Chat> getChat(Map data) {
		getChat(data as GetChatMethodObject)
	}

	@Override
	TelegramResult<Chat> getChat(@DelegatesTo(GetChatMethodObject) Closure closure) {
		def builder = GetChatMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		getChat(builder)
	}
}
