package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait UnpinChatMessage {

	def unpinChatMessage(chatId = lastUpdate.updateData[lastUpdate.updateType].chat.id, Map params = [:]) {
		api.go(new Some('unpinChatMessage', [chat_id: chatId] + params))
	}
}