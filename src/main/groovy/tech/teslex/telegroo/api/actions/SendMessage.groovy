package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait SendMessage {

	def sendMessage(text, Map params = [:]) {
		sendMessage(text.toString(), lastUpdate.message.chat.id, params)
	}

	def sendMessage(text, chatId, Map params = [:]) {
		api.go(new Some('sendMessage', [chat_id: chatId, text: text.toString()] + params))
	}
}
