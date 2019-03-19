package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.methods.KickChatMemberMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.KickChatMemberMethodObject

@CompileStatic
trait KickChatMemberMethodTrait implements KickChatMemberMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> kickChatMember(@NamedDelegate KickChatMemberMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> kickChatMember(Map data) {
		kickChatMember(data as KickChatMemberMethodObject)
	}

	@Override
	TelegramResult<Object> kickChatMember(@DelegatesTo(KickChatMemberMethodObject) Closure closure) {
		def builder = KickChatMemberMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		kickChatMember(builder)
	}
}
