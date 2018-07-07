package tech.teslex.telegroo.api.actions

trait SetChatDescription {

	def setChatDescription(String description, Map params = [:]) {
		setChatDescription(description, lastUpdate.message.chat.id)
	}

	def setChatDescription(String description, chatId, Map params = [:]) {
		api.go('setChatTitle', [chat_id: chatId, description: description] + params)
	}
}