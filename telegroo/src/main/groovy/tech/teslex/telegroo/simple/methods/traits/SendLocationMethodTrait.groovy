package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.SendLocationMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SendLocationMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendLocationMethodTrait implements SendLocationMethod<TelegramResult<Message>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Message> sendLocation(@NamedDelegate SendLocationMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> sendLocation(Map data) {
		sendLocation(data as SendLocationMethodObject)
	}

	@Override
	TelegramResult<Message> sendLocation(@DelegatesTo(SendLocationMethodObject) Closure closure) {
		def builder = SendLocationMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		sendLocation(builder)
	}
}