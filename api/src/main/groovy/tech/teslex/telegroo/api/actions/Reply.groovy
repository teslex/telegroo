package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.some.Some

trait Reply {

	def reply(message, Map params = [:]) {
		reply(message.toString(), lastUpdate.updateData.message.message_id, params)
	}

	def reply(message, replyTo, chatId = lastUpdate.updateData.message.chat.id, Map params = [:]) {
		sendMessage(message.toString(), chatId, [reply_to_message_id: replyTo] + params)
	}

	def reply(replyTo = lastUpdate.updateData.message.message_id, Closure action) {
		api.defaultParams << [reply_to_message_id: replyTo]
		action.call()
		api.defaultParams.remove(new Some('reply_to_message_id'))
	}
}