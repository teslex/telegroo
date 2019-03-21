package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.RestrictChatMemberMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.RestrictChatMemberMethodObject

@CompileStatic
trait RestrictChatMemberMethodTrait implements RestrictChatMemberMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> restrictChatMember(@NamedDelegate RestrictChatMemberMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> restrictChatMember(Map data) {
		restrictChatMember(data as RestrictChatMemberMethodObject)
	}

	@Override
	TelegramResult<Object> restrictChatMember(@DelegatesTo(RestrictChatMemberMethodObject) Closure closure) {
		def builder = RestrictChatMemberMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		restrictChatMember(builder)
	}
}
