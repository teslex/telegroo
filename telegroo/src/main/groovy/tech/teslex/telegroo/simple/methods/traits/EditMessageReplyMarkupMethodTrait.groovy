package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.EditMessageReplyMarkupMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.EditMessageReplyMarkupMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait EditMessageReplyMarkupMethodTrait implements EditMessageReplyMarkupMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> editMessageReplyMarkup(@NamedDelegate EditMessageReplyMarkupMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']
		data.messageId = data.messageId ?: lastUpdate[lastUpdate.updateType.value]['messageId'] as Integer

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> editMessageReplyMarkup(Map data) {
		editMessageReplyMarkup(data as EditMessageReplyMarkupMethodObject)
	}

	@Override
	TelegramResult<Object> editMessageReplyMarkup(@DelegatesTo(EditMessageReplyMarkupMethodObject) Closure closure) {
		def builder = EditMessageReplyMarkupMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		editMessageReplyMarkup(builder)
	}
}
