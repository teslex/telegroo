package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.GetChatMemberMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.GetChatMemberMethodObject
import tech.teslex.telegroo.telegram.types.ChatMember

@CompileStatic
trait GetChatMemberMethodTrait implements GetChatMemberMethod<TelegramResult<ChatMember>>, ContextWithObjectMapper {

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
		def builder = GetChatMemberMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		getChatMember(builder)
	}
}