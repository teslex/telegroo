package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.builders.UnbanChatMemberMethodObjectBuilder
import tech.teslex.telegroo.telegram.methods.objects.UnbanChatMemberMethodObject

@CompileStatic
trait UnbanChatMemberMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Object> unbanChatMember(@NamedDelegate UnbanChatMemberMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> unbanChatMember(Map data) {
		unbanChatMember(data as UnbanChatMemberMethodObject)
	}

	TelegramResult<Object> unbanChatMember(@DelegatesTo(UnbanChatMemberMethodObjectBuilder) Closure closure) {
		def builder = new UnbanChatMemberMethodObjectBuilder()
		closure.delegate = builder
		closure.call()
		unbanChatMember(builder.build())
	}
}