package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.SendMediaGroupMethod
import tech.teslex.telegroo.telegram.methods.objects.SendMediaGroupMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait SendMediaGroupMethodTrait implements SendMediaGroupMethod<TelegramResult<Message>> {

	@Override
	@NamedVariant
	TelegramResult<Message> sendMediaGroup(@NamedDelegate SendMediaGroupMethodObject data) {
		data.chatId = data.chatId ?: update[update.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(telegramClient.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> sendMediaGroup(Map data) {
		sendMediaGroup(data as SendMediaGroupMethodObject)
	}

	@Override
	TelegramResult<Message> sendMediaGroup(@DelegatesTo(SendMediaGroupMethodObject) Closure closure) {
		SendMediaGroupMethodObject builder = new SendMediaGroupMethodObject()
		closure.delegate = builder
		closure.call()
		sendMediaGroup(builder)
	}
}