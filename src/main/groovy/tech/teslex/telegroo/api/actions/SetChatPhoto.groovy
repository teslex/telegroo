package tech.teslex.telegroo.api.actions

trait SetChatPhoto {

	def setChatPhoto(File photo, Map params = [:]) {
		setChatPhoto(photo, lastUpdate.message.chat.id)
	}

	def setChatPhoto(File photo, chatId, Map params = [:]) {
		api.goWithFile('setChatPhoto', photo, 'photo', [chat_id: chatId] + params)
	}
}