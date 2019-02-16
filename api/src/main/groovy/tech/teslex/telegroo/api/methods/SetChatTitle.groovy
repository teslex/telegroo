package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait SetChatTitle {

	def setChatTitle(String title, Map params = [:]) {
		setChatTitle(title, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def setChatTitle(String title, chatId, Map params = [:]) {
		api.go(new Some('setChatTitle', [chat_id: chatId, title: title] + params))
	}
}