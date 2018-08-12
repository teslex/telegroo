package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait DeleteChatPhoto {

	def deleteChatPhoto(Map params = [:]) {
		deleteChatPhoto(lastUpdate.message.chat.id, params)
	}

	def deleteChatPhoto(chatId, Map params = [:]) {
		api.go(new Some('deleteChatPhoto', [chat_id: chatId] + params))
	}
}