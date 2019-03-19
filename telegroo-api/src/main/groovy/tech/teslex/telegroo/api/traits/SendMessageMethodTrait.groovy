package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SendMessageMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendMessageMethodTrait implements Context<Response> {

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
		sendMessage([text: text, chatId: chatId] as SendMessageMethodObject)
	}

	TelegramResult<Message> sendMessage(@DelegatesTo(SendMessageMethodObject) Closure closure) {
		def builder = SendMessageMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		sendMessage(builder)
	}
}