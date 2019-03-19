package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.methods.EditMessageCaptionMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.EditMessageCaptionMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait EditMessageCaptionMethodTrait implements EditMessageCaptionMethod<TelegramResult<Message>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Message> editMessageCaption(@NamedDelegate EditMessageCaptionMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']
		data.messageId = data.messageId ?: lastUpdate[lastUpdate.updateType.type]['messageId'] as Integer

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> editMessageCaption(Map data) {
		editMessageCaption(data as EditMessageCaptionMethodObject)
	}

	@Override
	TelegramResult<Message> editMessageCaption(@DelegatesTo(EditMessageCaptionMethodObject) Closure closure) {
		def builder = EditMessageCaptionMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		editMessageCaption(builder)
	}
}
