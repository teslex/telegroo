package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait SendLocation {

	def sendLocation(latitude, longitude, Map params = [:]) {
		sendLocation(latitude, longitude, lastUpdate.updateData[lastUpdate.updateType].chat.id)
	}

	def sendLocation(latitude, longitude, chatId, Map params = [:]) {
		api.go(new Some('sendLocation', [chat_id: chatId, latitude: latitude, longitude: longitude] + params))
	}
}
