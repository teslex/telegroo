package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait SendContact {

	def sendContact(String phoneNumber, String firstName, Map params = [:]) {
		sendContact(phoneNumber, firstName, lastUpdate.message.chat.id)
	}

	def sendContact(String phoneNumber, String firstName, chatId, Map params = [:]) {
		api.go(new Some('sendContact', [chat_id: chatId, phone_number: phoneNumber, first_name: firstName] + params))
	}
}
