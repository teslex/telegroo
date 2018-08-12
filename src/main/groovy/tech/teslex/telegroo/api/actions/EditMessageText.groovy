package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait EditMessageText {

	def editMessageText(messageId, String text, Map params = [:]) {
		editMessageText(messageId, text, lastUpdate.message.chat.id, params)
	}

	def editMessageText(messageId, String text, chatId, Map params = [:]) {
		api.go(new Some('editMessageText', [chat_id: chatId, message_id: messageId, text: text] + params))
	}
}
