package tech.teslex.telegroo.api.actions

trait DeleteChatPhoto {

	def deleteChatPhoto(Map params = [:]) {
		deleteChatPhoto(lastUpdate.message.chat.id, params)
	}

	def deleteChatPhoto(chatId, Map params = [:]) {
		api.go('deleteChatPhoto', [chat_id: chatId] + params)
	}
}