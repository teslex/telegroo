package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.EditMessageTextMethod
import tech.teslex.telegroo.telegram.methods.objects.EditMessageTextMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait EditMessageTextMethodTrait implements EditMessageTextMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> editMessageText(@NamedDelegate EditMessageTextMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']
		data.messageId = data.messageId ?: lastUpdate[lastUpdate.updateType.value]['messageId'] as Integer

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> editMessageText(Map data) {
		editMessageText(data as EditMessageTextMethodObject)
	}

	@Override
	TelegramResult<Object> editMessageText(@DelegatesTo(EditMessageTextMethodObject) Closure closure) {
		EditMessageTextMethodObject builder = new EditMessageTextMethodObject()
		closure.delegate = builder
		closure.call()
		editMessageText(builder)
	}
}
