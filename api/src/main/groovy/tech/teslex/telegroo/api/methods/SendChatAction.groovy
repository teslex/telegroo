package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.enums.ChatAction
import tech.teslex.telegroo.api.some.Some

trait SendChatAction {

	def sendChatAction(action, Map params = [:]) {
		sendChatAction(action.toString(), lastUpdate.updateData[lastUpdate.updateType].from.id, params)
	}

	def sendChatAction(ChatAction chatAction, Map params = [:]) {
		sendChatAction(chatAction.action, lastUpdate.updateData[lastUpdate.updateType].from.id, params)
	}

	def sendChatAction(action, chatId, Map params = [:]) {
		api.go(new Some('sendChatAction', [chat_id: chatId, action: action.toString()] + params))
	}
}
