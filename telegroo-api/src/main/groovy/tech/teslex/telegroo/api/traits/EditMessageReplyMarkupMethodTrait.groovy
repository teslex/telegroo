package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.EditMessageReplyMarkupMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait EditMessageReplyMarkupMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Message> editMessageReplyMarkup(@NamedDelegate EditMessageReplyMarkupMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']
		data.messageId = data.messageId ?: lastUpdate[lastUpdate.updateType.type]['messageId'] as Integer

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> editMessageReplyMarkup(Map data) {
		editMessageReplyMarkup(new EditMessageReplyMarkupMethodObject(data))
	}
}
