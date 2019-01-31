package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait SendLocation {

	def sendLocation(latitude, longitude, Map params = [:]) {
		sendLocation(latitude, longitude, lastUpdate.message.chat.id)
	}

	def sendLocation(latitude, longitude, chatId, Map params = [:]) {
		api.go(new Some('sendLocation', [chat_id: chatId, latitude: latitude, longitude: longitude] + params))
	}
}
