package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.SendMediaGroupMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SendMediaGroupMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendMediaGroupMethodTrait implements SendMediaGroupMethod<TelegramResult<Message>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Message> sendMediaGroup(@NamedDelegate SendMediaGroupMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> sendMediaGroup(Map data) {
		sendMediaGroup(data as SendMediaGroupMethodObject)
	}

	@Override
	TelegramResult<Message> sendMediaGroup(@DelegatesTo(SendMediaGroupMethodObject) Closure closure) {
		def builder = SendMediaGroupMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		sendMediaGroup(builder)
	}
}