package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.KickChatMemberMethodObject

@CompileStatic
trait KickChatMemberMethodTrait implements Context<Response> {

	@NamedVariant
	TelegramResult<Object> kickChatMember(@NamedDelegate KickChatMemberMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> kickChatMember(Map data) {
		kickChatMember(data as KickChatMemberMethodObject)
	}

	TelegramResult<Object> kickChatMember(@DelegatesTo(KickChatMemberMethodObject) Closure closure) {
		def builder = KickChatMemberMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		kickChatMember(builder)
	}
}
