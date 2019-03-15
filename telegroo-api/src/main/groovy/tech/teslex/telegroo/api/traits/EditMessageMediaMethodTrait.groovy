package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.EditMessageMediaMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait EditMessageMediaMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Message> editMessageMedia(@NamedDelegate EditMessageMediaMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']
		data.messageId = data.messageId ?: lastUpdate[lastUpdate.updateType.type]['messageId'] as Integer

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> editMessageMedia(Map data) {
		editMessageMedia(new EditMessageMediaMethodObject(data))
	}
}
