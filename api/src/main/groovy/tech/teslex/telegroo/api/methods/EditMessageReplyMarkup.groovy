package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait EditMessageReplyMarkup {

	def editMessageReplyMarkup(messageId, Map params = [:]) {
		api.go(new Some('editMessageReplyMarkup', [chat_id: lastUpdate.updateData[lastUpdate.updateType].chat.id, message_id: messageId, reply_markup: [:]] + params))
	}

	def editMessageReplyMarkup(messageId, Map replyMarkup, chatId, Map params = [:]) {
		api.go(new Some('editMessageReplyMarkup', [chat_id: chatId, message_id: messageId, reply_markup: replyMarkup] + params))
	}
}