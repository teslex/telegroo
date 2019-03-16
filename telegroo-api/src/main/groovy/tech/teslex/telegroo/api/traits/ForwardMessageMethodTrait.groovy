package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.builders.ForwardMessageMethodObjectBuilder
import tech.teslex.telegroo.telegram.methods.objects.ForwardMessageMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait ForwardMessageMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Message> forwardMessage(@NamedDelegate ForwardMessageMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']
		data.messageId = data.messageId ?: lastUpdate[lastUpdate.updateType.type]['messageId'] as Integer

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> forwardMessage(Map data) {
		forwardMessage(data as ForwardMessageMethodObject)
	}

	TelegramResult<Message> forwardMessage(@DelegatesTo(ForwardMessageMethodObjectBuilder) Closure closure) {
		def builder = new ForwardMessageMethodObjectBuilder()
		closure.delegate = builder
		closure.call()
		forwardMessage(builder.build())
	}
}