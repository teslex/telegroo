package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.EditMessageLiveLocationMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.EditMessageLiveLocationMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait EditMessageLiveLocationMethodTrait implements EditMessageLiveLocationMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> editMessageLiveLocation(@NamedDelegate EditMessageLiveLocationMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']
		data.messageId = data.messageId ?: lastUpdate[lastUpdate.updateType.value]['messageId'] as Integer

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> editMessageLiveLocation(Map data) {
		editMessageLiveLocation(data as EditMessageLiveLocationMethodObject)
	}

	@Override
	TelegramResult<Object> editMessageLiveLocation(@DelegatesTo(EditMessageLiveLocationMethodObject) Closure closure) {
		def builder = EditMessageLiveLocationMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		editMessageLiveLocation(builder)
	}
}
