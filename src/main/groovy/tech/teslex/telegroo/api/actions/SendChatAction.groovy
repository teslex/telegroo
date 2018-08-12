package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait SendChatAction {

	def sendChatAction(String action, Map params = [:]) {
		sendChatAction(action, lastUpdate.message.from.id, params)
	}

	def sendChatAction(String action, chatId, Map params = [:]) {
		api.go(new Some('sendChatAction', [chat_id: chatId, action: action] + params))
	}
}
