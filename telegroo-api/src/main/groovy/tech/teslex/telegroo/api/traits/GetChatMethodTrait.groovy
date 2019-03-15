package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.GetChatMethodObject
import tech.teslex.telegroo.telegram.types.Chat

@CompileStatic
trait GetChatMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Chat> getChat(@NamedDelegate GetChatMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Chat)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Chat> getChat(Map data) {
		getChat(new GetChatMethodObject(data))
	}
}
