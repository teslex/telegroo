package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.EditMessageCaptionMethod
import tech.teslex.telegroo.telegram.methods.objects.EditMessageCaptionMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait EditMessageCaptionMethodTrait implements EditMessageCaptionMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> editMessageCaption(@NamedDelegate EditMessageCaptionMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']
		data.messageId = data.messageId ?: lastUpdate[lastUpdate.updateType.value]['messageId'] as Integer

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> editMessageCaption(Map data) {
		editMessageCaption(data as EditMessageCaptionMethodObject)
	}

	@Override
	TelegramResult<Object> editMessageCaption(@DelegatesTo(EditMessageCaptionMethodObject) Closure closure) {
		EditMessageCaptionMethodObject builder = new EditMessageCaptionMethodObject()
		closure.delegate = builder
		closure.call()
		editMessageCaption(builder)
	}
}
