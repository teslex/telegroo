package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.GetChatMemberMethod
import tech.teslex.telegroo.telegram.methods.objects.GetChatMemberMethodObject
import tech.teslex.telegroo.telegram.types.ChatMember

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait GetChatMemberMethodTrait implements GetChatMemberMethod<TelegramResult<ChatMember>> {

	@Override
	@NamedVariant
	TelegramResult<ChatMember> getChatMember(@NamedDelegate GetChatMemberMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, ChatMember)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<ChatMember> getChatMember(Map data) {
		getChatMember(data as GetChatMemberMethodObject)
	}

	@Override
	TelegramResult<ChatMember> getChatMember(@DelegatesTo(GetChatMemberMethodObject) Closure closure) {
		GetChatMemberMethodObject builder = new GetChatMemberMethodObject()
		closure.delegate = builder
		closure.call()
		getChatMember(builder)
	}
}