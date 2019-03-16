package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.RestrictChatMemberMethodObject

@CompileStatic
trait RestrictChatMemberMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Object> restrictChatMemberMethod(@NamedDelegate RestrictChatMemberMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> restrictChatMemberMethod(Map data) {
		restrictChatMemberMethod(data as RestrictChatMemberMethodObject)
	}

	TelegramResult<Object> restrictChatMemberMethod(@DelegatesTo(RestrictChatMemberMethodObject) Closure closure) {
		def builder = RestrictChatMemberMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		restrictChatMemberMethod(builder)
	}
}
