package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait SendMessage {

	def sendMessage(String text, Map params = [:]) {
		sendMessage(text, lastUpdate.message.chat.id, params)
	}

	def sendMessage(String text, chatId, Map params = [:]) {
		api.go(new Some('sendMessage', [chat_id: chatId, text: text] + params))
	}
}
