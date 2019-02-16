package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait EditMessageCaption {

	def editMessageCaption(messageId, caption = '', Map params = [:]) {
		editMessageCaption(messageId, lastUpdate.updateData[lastUpdate.updateType].chat.id, caption.toString(), params)
	}

	def editMessageCaption(messageId, chatId, caption , Map params = [:]) {
		api.go(new Some('editMessageCaption', [chat_id: chatId, message_id: messageId, caption: caption.toString()] + params))
	}
}
