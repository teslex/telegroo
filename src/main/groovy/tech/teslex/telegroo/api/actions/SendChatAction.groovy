package tech.teslex.telegroo.api.actions

trait SendChatAction {

	def sendChatAction(String action, Map params = [:]) {
		sendChatAction(action, lastUpdate.message.from.id, params)
	}

	def sendChatAction(String action, chatId, Map params = [:]) {
		api.go('sendChatAction', [chat_id: chatId, action: action] + params)
	}
}
