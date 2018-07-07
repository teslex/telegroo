package tech.teslex.telegroo.api.actions

trait EditMessageLiveLocation {

	def editMessageLiveLocation(int messageId, float latitude, float longitude, Map params = [:]) {
		editMessageLiveLocation(messageId, latitude, longitude, lastUpdate.message.chat.id, params)
	}

	def editMessageLiveLocation(int messageId, float latitude, float longitude, chatId, Map params = [:]) {
		api.go('editMessageLiveLocation', [chat_id: chatId, message_id: messageId, latitude: latitude, longitude: longitude] + params)
	}
}
