package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.GetChatMembersCountMethodObject

@CompileStatic
trait GetChatMembersCountMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Integer> getChatMembersCount(@NamedDelegate GetChatMembersCountMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Integer)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Integer> getChatMembersCount(Map data) {
		getChatMembersCount(new GetChatMembersCountMethodObject(data))
	}
}
