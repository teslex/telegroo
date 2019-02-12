package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.some.Some

trait EditMessageLiveLocation {

	def editMessageLiveLocation(messageId, latitude, longitude, Map params = [:]) {
		editMessageLiveLocation(messageId, latitude, longitude, lastUpdate.updateData.message.chat.id, params)
	}

	def editMessageLiveLocation(messageId, latitude, longitude, chatId, Map params = [:]) {
		api.go(new Some('editMessageLiveLocation', [chat_id: chatId, message_id: messageId, latitude: latitude, longitude: longitude] + params))
	}
}
