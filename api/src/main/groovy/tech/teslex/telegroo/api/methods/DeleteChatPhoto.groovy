package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait DeleteChatPhoto {

	def deleteChatPhoto(Map params = [:]) {
		deleteChatPhoto(lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def deleteChatPhoto(chatId, Map params = [:]) {
		api.go(new Some('deleteChatPhoto', [chat_id: chatId] + params))
	}
}