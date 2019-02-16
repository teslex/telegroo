package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait StopMessageLiveLocation {

	def stopMessageLiveLocation(int messageId, Map params = [:]) {
		stopMessageLiveLocation(messageId, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def stopMessageLiveLocation(int messageId, chatId, Map params = [:]) {
		api.go(new Some('stopMessageLiveLocation', [chat_id: chatId, message_id: messageId] + params))
	}
}