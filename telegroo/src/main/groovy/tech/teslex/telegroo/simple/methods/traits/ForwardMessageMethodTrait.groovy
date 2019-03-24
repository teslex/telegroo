package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.ForwardMessageMethod
import tech.teslex.telegroo.telegram.methods.objects.ForwardMessageMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait ForwardMessageMethodTrait implements ForwardMessageMethod<TelegramResult<Message>> {

	@Override
	@NamedVariant
	TelegramResult<Message> forwardMessage(@NamedDelegate ForwardMessageMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']
		data.messageId = data.messageId ?: lastUpdate[lastUpdate.updateType.value]['messageId'] as Integer

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> forwardMessage(Map data) {
		forwardMessage(data as ForwardMessageMethodObject)
	}

	@Override
	TelegramResult<Message> forwardMessage(@DelegatesTo(ForwardMessageMethodObject) Closure closure) {
		ForwardMessageMethodObject builder = new ForwardMessageMethodObject()
		closure.delegate = builder
		closure.call()
		forwardMessage(builder)
	}
}