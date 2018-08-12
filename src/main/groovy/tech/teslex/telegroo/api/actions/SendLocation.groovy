package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait SendLocation {

	def sendLocation(float latitude, float longitude, Map params = [:]) {
		sendLocation(latitude, longitude, lastUpdate.message.chat.id)
	}

	def sendLocation(float latitude, float longitude, chatId, Map params = [:]) {
		api.go(new Some('sendLocation', [chat_id: chatId, latitude: latitude, longitude: longitude] + params))
	}
}
