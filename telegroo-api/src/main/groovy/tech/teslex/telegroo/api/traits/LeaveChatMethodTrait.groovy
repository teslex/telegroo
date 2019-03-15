package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.LeaveChatMethodObject

@CompileStatic
trait LeaveChatMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Object> leaveChat(@NamedDelegate LeaveChatMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> leaveChat(Map data) {
		leaveChat(new LeaveChatMethodObject(data))
	}
}
