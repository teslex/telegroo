package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.PromoteChatMemberMethodObject

@CompileStatic
trait PromoteChatMemberMethodTrait implements Context<Response> {

	@NamedVariant
	TelegramResult<Object> promoteChatMember(@NamedDelegate PromoteChatMemberMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> promoteChatMember(Map data) {
		promoteChatMember(data as PromoteChatMemberMethodObject)
	}

	TelegramResult<Object> promoteChatMember(@DelegatesTo(PromoteChatMemberMethodObject) Closure closure) {
		def builder = PromoteChatMemberMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		promoteChatMember(builder)
	}
}
