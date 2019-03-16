package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.builders.SendLocationMethodObjectBuilder
import tech.teslex.telegroo.telegram.methods.objects.SendLocationMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendLocationMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Message> sendLocation(@NamedDelegate SendLocationMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> sendLocation(Map data) {
		sendLocation(data as SendLocationMethodObject)
	}

	TelegramResult<Message> sendLocation(@DelegatesTo(SendLocationMethodObjectBuilder) Closure closure) {
		def builder = new SendLocationMethodObjectBuilder()
		closure.delegate = builder
		closure.call()
		sendLocation(builder.build())
	}
}