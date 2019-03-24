package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.EditMessageMediaMethod
import tech.teslex.telegroo.telegram.methods.objects.EditMessageMediaMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait EditMessageMediaMethodTrait implements EditMessageMediaMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> editMessageMedia(@NamedDelegate EditMessageMediaMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']
		data.messageId = data.messageId ?: lastUpdate[lastUpdate.updateType.value]['messageId'] as Integer

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> editMessageMedia(Map data) {
		editMessageMedia(data as EditMessageMediaMethodObject)
	}

	@Override
	TelegramResult<Object> editMessageMedia(@DelegatesTo(EditMessageMediaMethodObject) Closure closure) {
		EditMessageMediaMethodObject builder = new EditMessageMediaMethodObject()
		closure.delegate = builder
		closure.call()
		editMessageMedia(builder)
	}
}
