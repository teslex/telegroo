package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.UnbanChatMemberMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.UnbanChatMemberMethodObject

@CompileStatic
trait UnbanChatMemberMethodTrait implements UnbanChatMemberMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> unbanChatMember(@NamedDelegate UnbanChatMemberMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> unbanChatMember(Map data) {
		unbanChatMember(data as UnbanChatMemberMethodObject)
	}

	@Override
	TelegramResult<Object> unbanChatMember(@DelegatesTo(UnbanChatMemberMethodObject) Closure closure) {
		def builder = UnbanChatMemberMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		unbanChatMember(builder)
	}
}