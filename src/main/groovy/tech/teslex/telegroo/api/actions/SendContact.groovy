package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait SendContact {

	def sendContact(phoneNumber, firstName, Map params = [:]) {
		sendContact(phoneNumber.toString(), firstName.toString(), lastUpdate.message.chat.id)
	}

	def sendContact(phoneNumber, firstName, chatId, Map params = [:]) {
		api.go(new Some('sendContact', [chat_id: chatId, phone_number: phoneNumber.toString(), first_name: firstName.toString()] + params))
	}
}
