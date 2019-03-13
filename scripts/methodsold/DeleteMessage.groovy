package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait DeleteMessage extends AbstractContext {

	def deleteMessage(Map params = [:]) {
		deleteMessage(lastUpdate.updateData[lastUpdate.updateType.type]['message_id'], lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	def deleteMessage(messageId, Map params = [:]) {
		deleteMessage(messageId, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	def deleteMessage(messageId, chatId, Map params = [:]) {
		api.go(new Some('deleteMessage', [chat_id: chatId, message_id: messageId] + params))
	}
}
