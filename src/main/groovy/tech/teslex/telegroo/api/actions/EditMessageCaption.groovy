package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait EditMessageCaption {

	def editMessageCaption(int messageId, String caption = '', Map params = [:]) {
		editMessageCaption(messageId, caption, lastUpdate.message.chat.id, params)
	}

	def editMessageCaption(int messageId, String caption = '', chatId, Map params = [:]) {
		api.go(new Some('editMessageCaption', [chat_id: chatId, message_id: messageId, caption: caption] + params))
	}
}
