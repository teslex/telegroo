package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait EditMessageLiveLocation {

	def editMessageLiveLocation(messageId, latitude, longitude, Map params = [:]) {
		editMessageLiveLocation(messageId, latitude, longitude, lastUpdate.message.chat.id, params)
	}

	def editMessageLiveLocation(messageId, latitude, longitude, chatId, Map params = [:]) {
		api.go(new Some('editMessageLiveLocation', [chat_id: chatId, message_id: messageId, latitude: latitude, longitude: longitude] + params))
	}
}
