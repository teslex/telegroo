package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.some.Some

trait EditMessageText {

	def editMessageText(messageId, text, Map params = [:]) {
		editMessageText(messageId, text.toString(), lastUpdate.updateData.message.chat.id, params)
	}

	def editMessageText(messageId, text, chatId, Map params = [:]) {
		api.go(new Some('editMessageText', [chat_id: chatId, message_id: messageId, text: text.toString()] + params))
	}
}
