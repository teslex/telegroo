package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.GetChatMemberMethodObject
import tech.teslex.telegroo.telegram.types.ChatMember

@CompileStatic
trait GetChatMemberMethodTrait implements Context<Response> {

	@NamedVariant
	TelegramResult<ChatMember> getChatMember(@NamedDelegate GetChatMemberMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, ChatMember)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<ChatMember> getChatMember(Map data) {
		getChatMember(data as GetChatMemberMethodObject)
	}

	TelegramResult<ChatMember> getChatMember(@DelegatesTo(GetChatMemberMethodObject) Closure closure) {
		def builder = GetChatMemberMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		getChatMember(builder)
	}
}