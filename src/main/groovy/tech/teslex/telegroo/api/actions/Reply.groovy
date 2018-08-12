package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait Reply {

	def reply(String message, Map params = [:]) {
		reply(message, lastUpdate.message.message_id, params)
	}

	def reply(String message, replyTo, Map params = [:]) {
		sendMessage(message, [reply_to_message_id: replyTo] + params)
	}

	def reply(replyTo = lastUpdate.message.message_id, Closure action) {
		api.defaultParams << [reply_to_message_id: replyTo]
		action.call()
		api.defaultParams.remove(new Some('reply_to_message_id'))
	}
}