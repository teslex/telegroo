package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.SendContactMethod
import tech.teslex.telegroo.telegram.methods.objects.SendContactMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait SendContactMethodTrait implements SendContactMethod<TelegramResult<Message>> {

	@Override
	@NamedVariant
	TelegramResult<Message> sendContact(@NamedDelegate SendContactMethodObject data) {
		data.chatId = data.chatId ?: update[update.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> sendContact(Map data) {
		sendContact(data as SendContactMethodObject)
	}

	@Override
	TelegramResult<Message> sendContact(@DelegatesTo(SendContactMethodObject) Closure closure) {
		SendContactMethodObject builder = new SendContactMethodObject()
		closure.delegate = builder
		closure.call()
		sendContact(builder)
	}
}
