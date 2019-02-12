package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.some.Some

trait DeleteChatPhoto {

	def deleteChatPhoto(Map params = [:]) {
		deleteChatPhoto(lastUpdate.updateData.message.chat.id, params)
	}

	def deleteChatPhoto(chatId, Map params = [:]) {
		api.go(new Some('deleteChatPhoto', [chat_id: chatId] + params))
	}
}