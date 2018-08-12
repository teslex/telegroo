package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait SetChatDescription {

	def setChatDescription(String description, Map params = [:]) {
		setChatDescription(description, lastUpdate.message.chat.id)
	}

	def setChatDescription(String description, chatId, Map params = [:]) {
		api.go(new Some('setChatTitle', [chat_id: chatId, description: description] + params))
	}
}