package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait EditMessageReplyMarkup extends AbstractContext {

	def editMessageReplyMarkup(messageId, Map params = [:]) {
		api.go(new Some('editMessageReplyMarkup', [chat_id: lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], message_id: messageId, reply_markup: [:]] + params))
	}

	def editMessageReplyMarkup(messageId, Map replyMarkup, chatId, Map params = [:]) {
		api.go(new Some('editMessageReplyMarkup', [chat_id: chatId, message_id: messageId, reply_markup: replyMarkup] + params))
	}
}