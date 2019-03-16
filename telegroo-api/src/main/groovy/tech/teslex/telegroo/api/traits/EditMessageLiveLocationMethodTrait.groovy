package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.builders.EditMessageLiveLocationMethodObjectBuilder
import tech.teslex.telegroo.telegram.methods.objects.EditMessageLiveLocationMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait EditMessageLiveLocationMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Message> editMessageLiveLocation(@NamedDelegate EditMessageLiveLocationMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']
		data.messageId = data.messageId ?: lastUpdate[lastUpdate.updateType.type]['messageId'] as Integer

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> editMessageLiveLocation(Map data) {
		editMessageLiveLocation(data as EditMessageLiveLocationMethodObject)
	}

	TelegramResult<Message> editMessageLiveLocation(@DelegatesTo(EditMessageLiveLocationMethodObjectBuilder) Closure closure) {
		def builder = new EditMessageLiveLocationMethodObjectBuilder()
		closure.delegate = builder
		closure.call()
		editMessageLiveLocation(builder.build())
	}
}
