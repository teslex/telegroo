package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.methods.SendDocumentMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SendDocumentMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendDocumentMethodTrait implements SendDocumentMethod<TelegramResult<Message>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Message> sendDocument(@NamedDelegate SendDocumentMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> sendDocument(Map data) {
		sendDocument(data as SendDocumentMethodObject)
	}

	@Override
	TelegramResult<Message> sendDocument(@DelegatesTo(SendDocumentMethodObject) Closure closure) {
		def builder = SendDocumentMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		sendDocument(builder)
	}
}