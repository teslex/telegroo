package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.EditMessageReplyMarkupMethod
import tech.teslex.telegroo.telegram.methods.objects.EditMessageReplyMarkupMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait EditMessageReplyMarkupMethodTrait implements EditMessageReplyMarkupMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> editMessageReplyMarkup(@NamedDelegate EditMessageReplyMarkupMethodObject data) {
		data.chatId = data.chatId ?: update[update.updateType.value]['chat']['id']
		data.messageId = data.messageId ?: update[update.updateType.value]['messageId'] as Integer

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(telegramClient.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> editMessageReplyMarkup(Map data) {
		editMessageReplyMarkup(data as EditMessageReplyMarkupMethodObject)
	}

	@Override
	TelegramResult<Object> editMessageReplyMarkup(@DelegatesTo(EditMessageReplyMarkupMethodObject) Closure closure) {
		EditMessageReplyMarkupMethodObject builder = new EditMessageReplyMarkupMethodObject()
		closure.delegate = builder
		closure.call()
		editMessageReplyMarkup(builder)
	}
}
