package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.EditMessageCaptionMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait EditMessageCaptionMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Message> editMessageCaption(@NamedDelegate EditMessageCaptionMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']
		data.messageId = data.messageId ?: lastUpdate[lastUpdate.updateType.type]['messageId'] as Integer

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> editMessageCaption(Map data) {
		editMessageCaption(new EditMessageCaptionMethodObject(data))
	}
}
