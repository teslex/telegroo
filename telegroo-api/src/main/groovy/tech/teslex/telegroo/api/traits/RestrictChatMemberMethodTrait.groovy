package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.RestrictChatMemberMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait RestrictChatMemberMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Object> restrictChatMemberMethodTrait(@NamedDelegate RestrictChatMemberMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> restrictChatMemberMethodTrait(Map data) {
		restrictChatMemberMethodTrait(new RestrictChatMemberMethodObject(data))
	}
}
