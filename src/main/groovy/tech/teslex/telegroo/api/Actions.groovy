package tech.teslex.telegroo.api

trait Actions {
	def getMe() {
		api.go('getMe')
	}

	def sendMessage(def chatId = lastUpdate.message.chat.id, String message, Map params = [:]) {
		api.go('sendMessage', [chat_id: chatId, text: message] + params)
	}

	def forward(def fromChatId = lastUpdate.message.chat.id, def messageId = lastUpdate.message.message_id, def chatId = lastUpdate.message.chat.id, Map params = [:]) {
		api.go('forwardMessage', [chat_id: chatId, from_chat_id: fromChatId, message_id: messageId] + params)
	}

	def reply(def chatId = lastUpdate.message.chat.id, def replyTo = lastUpdate.message.message_id, String message, Map params = [:]) {
		sendMessage(chatId, message, [reply_to_message_id: replyTo] + params)
	}

	// small hack :)
	Api getApi() {
		return api
	}
}