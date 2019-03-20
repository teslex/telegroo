package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.SendMessageMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SendMessageMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendMessageMethodTrait implements SendMessageMethod<TelegramResult<Message>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Message> sendMessage(@NamedDelegate SendMessageMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> sendMessage(Map data) {
		sendMessage(data as SendMessageMethodObject)
	}

	@Override
	TelegramResult<Message> sendMessage(@DelegatesTo(SendMessageMethodObject) Closure closure) {
		def builder = SendMessageMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		sendMessage(builder)
	}
}