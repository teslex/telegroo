package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait SetChatTitle {

	def setChatTitle(String title, Map params = [:]) {
		setChatTitle(title, lastUpdate.message.chat.id, params)
	}

	def setChatTitle(String title, chatId, Map params = [:]) {
		api.go(new Some('setChatTitle', [chat_id: chatId, title: title] + params))
	}
}