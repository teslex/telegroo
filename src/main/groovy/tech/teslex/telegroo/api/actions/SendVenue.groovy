package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait SendVenue {

	def sendVenue(float latitude, float longitude, String title, String address, Map params = [:]) {
		sendVenue(latitude, longitude, title, address, lastUpdate.message.chat.id, params)
	}

	def sendVenue(float latitude, float longitude, String title, String address, chatId, Map params = [:]) {
		api.go(new Some('sendVenue', [chat_id: chatId, latitude: latitude, longitude: longitude, title: title, address: address] + params))
	}
}