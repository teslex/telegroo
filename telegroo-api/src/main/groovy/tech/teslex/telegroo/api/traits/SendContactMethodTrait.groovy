package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SendContactMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendContactMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Message> sendContact(@NamedDelegate SendContactMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> sendContact(Map data) {
		sendContact(data as SendContactMethodObject)
	}

	TelegramResult<Message> sendContact(@DelegatesTo(SendContactMethodObject) Closure closure) {
		def builder = SendContactMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		sendContact(builder)
	}
}
