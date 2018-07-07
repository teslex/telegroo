package tech.teslex.telegroo.api.actions

trait SetChatTitle {

	def setChatTitle(String title, Map params = [:]) {
		setChatTitle(title, lastUpdate.message.chat.id, params)
	}

	def setChatTitle(String title, chatId, Map params = [:]) {
		api.go('setChatTitle', [chat_id: chatId, title: title] + params)
	}
}