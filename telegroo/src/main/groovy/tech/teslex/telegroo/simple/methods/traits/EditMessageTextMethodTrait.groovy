package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.EditMessageTextMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.EditMessageTextMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait EditMessageTextMethodTrait implements EditMessageTextMethod<TelegramResult<Message>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Message> editMessageText(@NamedDelegate EditMessageTextMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']
		data.messageId = data.messageId ?: lastUpdate[lastUpdate.updateType.value]['messageId'] as Integer

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> editMessageText(Map data) {
		editMessageText(data as EditMessageTextMethodObject)
	}

	@Override
	TelegramResult<Message> editMessageText(@DelegatesTo(EditMessageTextMethodObject) Closure closure) {
		def builder = EditMessageTextMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		editMessageText(builder)
	}
}
