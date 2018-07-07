package tech.teslex.telegroo.api.actions

trait StopMessageLiveLocation {

	def stopMessageLiveLocation(int messageId, Map params = [:]) {
		stopMessageLiveLocation(messageId, lastUpdate.message.chat.id, params)
	}

	def stopMessageLiveLocation(int messageId, chatId, Map params = [:]) {
		api.go('stopMessageLiveLocation', [chat_id: chatId, message_id: messageId] + params)
	}
}
