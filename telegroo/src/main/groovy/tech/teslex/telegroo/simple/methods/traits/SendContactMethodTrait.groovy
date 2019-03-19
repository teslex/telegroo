package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.methods.SendContactMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SendContactMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendContactMethodTrait implements SendContactMethod<TelegramResult<Message>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Message> sendContact(@NamedDelegate SendContactMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> sendContact(Map data) {
		sendContact(data as SendContactMethodObject)
	}

	@Override
	TelegramResult<Message> sendContact(@DelegatesTo(SendContactMethodObject) Closure closure) {
		def builder = SendContactMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		sendContact(builder)
	}
}
