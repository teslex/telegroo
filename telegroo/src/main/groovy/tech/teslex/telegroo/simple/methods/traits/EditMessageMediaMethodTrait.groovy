package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.EditMessageMediaMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.EditMessageMediaMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait EditMessageMediaMethodTrait implements EditMessageMediaMethod<TelegramResult<Message>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Message> editMessageMedia(@NamedDelegate EditMessageMediaMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']
		data.messageId = data.messageId ?: lastUpdate[lastUpdate.updateType.type]['messageId'] as Integer

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> editMessageMedia(Map data) {
		editMessageMedia(data as EditMessageMediaMethodObject)
	}

	@Override
	TelegramResult<Message> editMessageMedia(@DelegatesTo(EditMessageMediaMethodObject) Closure closure) {
		def builder = EditMessageMediaMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		editMessageMedia(builder)
	}
}