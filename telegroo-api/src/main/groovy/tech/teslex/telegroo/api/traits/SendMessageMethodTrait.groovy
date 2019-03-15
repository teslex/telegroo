package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.builders.SendMessageMethodObjectBuilder
import tech.teslex.telegroo.telegram.methods.objects.SendMessageMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendMessageMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Message> sendMessage(@NamedDelegate SendMessageMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> sendMessage(Map data) {
		sendMessage(data as SendMessageMethodObject)
	}

	TelegramResult<Message> sendMessage(String text, chatId = lastUpdate[lastUpdate.updateType.type]['chat']['id']) {
		sendMessage(new SendMessageMethodObject(text: text, chatId: chatId))
	}

	TelegramResult<Message> sendMessage(@DelegatesTo(SendMessageMethodObjectBuilder) Closure closure) {
		def builder = new SendMessageMethodObjectBuilder()
		closure.delegate = builder
		closure.call()
		sendMessage(builder.build())
	}
}