package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some
import tech.teslex.telegroo.api.telegram.types.Message

@CompileStatic
trait Forward extends AbstractContext {

	Message forward(Map params = [:]) {
		forward(lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], lastUpdate.updateData[lastUpdate.updateType.type]['message_id'], lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	Message forward(chatId, Map params = [:]) {
		forward(lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], lastUpdate.updateData[lastUpdate.updateType.type]['message_id'], chatId, params)
	}

	Message forward(fromChatId, messageId, chatId, Map params = [:]) {
		def result = api.go(new Some('forwardMessage', [chat_id: chatId, from_chat_id: fromChatId, message_id: messageId] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}
}
