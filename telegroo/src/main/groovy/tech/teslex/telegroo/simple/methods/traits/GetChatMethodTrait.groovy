package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.GetChatMethod
import tech.teslex.telegroo.telegram.methods.objects.GetChatMethodObject
import tech.teslex.telegroo.telegram.types.Chat

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait GetChatMethodTrait implements GetChatMethod<TelegramResult<Chat>> {

	@Override
	@NamedVariant
	TelegramResult<Chat> getChat(@NamedDelegate GetChatMethodObject data) {
		data.chatId = data.chatId ?: update[update.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Chat)

		objectMapper.readValue(telegramClient.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Chat> getChat(Map data) {
		getChat(data as GetChatMethodObject)
	}

	@Override
	TelegramResult<Chat> getChat(@DelegatesTo(GetChatMethodObject) Closure closure) {
		GetChatMethodObject builder = new GetChatMethodObject()
		closure.delegate = builder
		closure.call()
		getChat(builder)
	}
}
