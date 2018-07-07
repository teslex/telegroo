package tech.teslex.telegroo.api.actions

trait SendMessage {

	def sendMessage(String text, Map params = [:]) {
		sendMessage(text, lastUpdate.message.chat.id, params)
	}

	def sendMessage(String text, chatId, Map params = [:]) {
		api.go('sendMessage', [chat_id: chatId, text: text] + params)
	}
}
