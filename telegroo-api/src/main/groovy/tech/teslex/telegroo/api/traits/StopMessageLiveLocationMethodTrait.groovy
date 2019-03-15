package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.StopMessageLiveLocationMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait StopMessageLiveLocationMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Message> stopMessageLiveLocation(@NamedDelegate StopMessageLiveLocationMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> stopMessageLiveLocation(Map data) {
		stopMessageLiveLocation(data as StopMessageLiveLocationMethodObject)
	}
}
