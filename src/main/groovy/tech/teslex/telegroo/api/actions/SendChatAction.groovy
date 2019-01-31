package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait SendChatAction {

	def sendChatAction(action, Map params = [:]) {
		sendChatAction(action.toString(), lastUpdate.message.from.id, params)
	}

	def sendChatAction(action, chatId, Map params = [:]) {
		api.go(new Some('sendChatAction', [chat_id: chatId, action: action.toString()] + params))
	}
}
