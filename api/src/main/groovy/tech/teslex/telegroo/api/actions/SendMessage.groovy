package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.some.Some

trait SendMessage {

	def sendMessage(text, Map params = [:]) {
		sendMessage(text.toString(), lastUpdate.updateData.message.chat.id, params)
	}

	def sendMessage(text, chatId, Map params = [:]) {
		api.go(new Some('sendMessage', [chat_id: chatId, text: text.toString()] + params))
	}
}
