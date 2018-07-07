package tech.teslex.telegroo.api.actions

trait EditMessageCaption {

	def editMessageCaption(int messageId, String caption = '', Map params = [:]) {
		editMessageCaption(messageId, caption, lastUpdate.message.chat.id, params)
	}

	def editMessageCaption(int messageId, String caption = '', chatId, Map params = [:]) {
		api.go('editMessageCaption', [chat_id: chatId, message_id: messageId, caption: caption] + params)
	}
}
