package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait DeleteMessage {

	def deleteMessage(Map params = [:]) {
		deleteMessage(lastUpdate.updateData[lastUpdate.updateType].message_id, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def deleteMessage(messageId, Map params = [:]) {
		deleteMessage(messageId, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def deleteMessage(messageId, chatId, Map params = [:]) {
		api.go(new Some('deleteMessage', [chat_id: chatId, message_id: messageId] + params))
	}
}
