package tech.teslex.telegroo.api.actions

trait EditMessageReplyMarkup {

	def editMessageReplyMarkup(int messageId, Map params = [:]) {
		api.go('editMessageReplyMarkup', [chat_id: lastUpdate.message.chat.id, message_id: messageId, reply_markup: [:]] + params)
	}

	def editMessageReplyMarkup(int messageId, Map replyMarkup, chatId, Map params = [:]) {
		api.go('editMessageReplyMarkup', [chat_id: chatId, message_id: messageId, reply_markup: replyMarkup] + params)
	}
}