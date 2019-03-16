package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.builders.EditMessageTextMethodObjectBuilder
import tech.teslex.telegroo.telegram.methods.objects.EditMessageTextMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait EditMessageTextMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Message> editMessageText(@NamedDelegate EditMessageTextMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']
		data.messageId = data.messageId ?: lastUpdate[lastUpdate.updateType.type]['messageId'] as Integer

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> editMessageText(Map data) {
		editMessageText(data as EditMessageTextMethodObject)
	}

	TelegramResult<Message> editMessageText(@DelegatesTo(EditMessageTextMethodObjectBuilder) Closure closure) {
		def builder = new EditMessageTextMethodObjectBuilder()
		closure.delegate = builder
		closure.call()
		editMessageText(builder.build())
	}
}
