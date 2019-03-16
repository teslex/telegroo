package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.builders.SendDocumentMethodObjectBuilder
import tech.teslex.telegroo.telegram.methods.objects.SendDocumentMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendDocumentMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Message> sendDocument(@NamedDelegate SendDocumentMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> sendDocument(Map data) {
		sendDocument(data as SendDocumentMethodObject)
	}

	TelegramResult<Message> sendDocument(@DelegatesTo(SendDocumentMethodObjectBuilder) Closure closure) {
		def builder = new SendDocumentMethodObjectBuilder()
		closure.delegate = builder
		closure.call()
		sendDocument(builder.build())
	}
}