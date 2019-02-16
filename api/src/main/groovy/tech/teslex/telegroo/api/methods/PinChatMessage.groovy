package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait PinChatMessage {

	def pinChatMessage(Map params = [:]) {
		pinChatMessage(lastUpdate.updateData[lastUpdate.updateType].message_id, params)
	}

	def pinChatMessage(messageId, Map params = [:]) {
		pinChatMessage(messageId, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def pinChatMessage(messageId, chatId, Map params = [:]) {
		api.go(new Some('pinChatMessage', [chat_id: chatId, message_id: messageId] + params))
	}
}