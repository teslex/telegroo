package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait PinChatMessage extends AbstractContext {

	def pinChatMessage(Map params = [:]) {
		pinChatMessage(lastUpdate.updateData[lastUpdate.updateType.type]['message_id'], params)
	}

	def pinChatMessage(messageId, Map params = [:]) {
		pinChatMessage(messageId, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	def pinChatMessage(messageId, chatId, Map params = [:]) {
		api.go(new Some('pinChatMessage', [chat_id: chatId, message_id: messageId] + params))
	}
}