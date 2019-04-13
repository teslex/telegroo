package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.EditMessageLiveLocationMethod
import tech.teslex.telegroo.telegram.methods.objects.EditMessageLiveLocationMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait EditMessageLiveLocationMethodTrait implements EditMessageLiveLocationMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> editMessageLiveLocation(@NamedDelegate EditMessageLiveLocationMethodObject data) {
		data.chatId = data.chatId ?: update[update.updateType.value]['chat']['id']
		data.messageId = data.messageId ?: update[update.updateType.value]['messageId'] as Integer

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(telegramClient.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> editMessageLiveLocation(Map data) {
		editMessageLiveLocation(data as EditMessageLiveLocationMethodObject)
	}

	@Override
	TelegramResult<Object> editMessageLiveLocation(@DelegatesTo(EditMessageLiveLocationMethodObject) Closure closure) {
		EditMessageLiveLocationMethodObject builder = new EditMessageLiveLocationMethodObject()
		closure.delegate = builder
		closure.call()
		editMessageLiveLocation(builder)
	}
}
