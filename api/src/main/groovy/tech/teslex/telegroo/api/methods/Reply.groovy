package tech.teslex.telegroo.api.methods

trait Reply {

	def reply(message, Map params = [:]) {
		reply(message.toString(), lastUpdate.updateData[lastUpdate.updateType].message_id, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def reply(message, replyTo, chatId, Map params = [:]) {
		sendMessage(message.toString(), chatId, [reply_to_message_id: replyTo] + params)
	}

	def reply(replyTo = lastUpdate.updateData[lastUpdate.updateType].message_id, Closure action) {
		api.defaultParams << [reply_to_message_id: replyTo]
		action.call()
		api.defaultParams.remove('reply_to_message_id')
	}
}