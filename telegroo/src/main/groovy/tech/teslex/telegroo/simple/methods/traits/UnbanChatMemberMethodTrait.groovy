package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.UnbanChatMemberMethodObject

@CompileStatic
trait UnbanChatMemberMethodTrait implements Context<Response> {

	@NamedVariant
	TelegramResult<Object> unbanChatMember(@NamedDelegate UnbanChatMemberMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> unbanChatMember(Map data) {
		unbanChatMember(data as UnbanChatMemberMethodObject)
	}

	TelegramResult<Object> unbanChatMember(@DelegatesTo(UnbanChatMemberMethodObject) Closure closure) {
		def builder = UnbanChatMemberMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		unbanChatMember(builder)
	}
}