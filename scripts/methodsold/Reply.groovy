package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait Reply extends AbstractContext {

	def reply(message, Map params = [:]) {
		reply(message.toString(), lastUpdate.updateData[lastUpdate.updateType.type]['message_id'], lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	def reply(message, replyTo, chatId, Map params = [:]) {
		api.go(new Some('sendMessage', [chat_id: chatId, text: message.toString(), reply_to_message_id: replyTo] + params))
	}

	def reply(replyTo = lastUpdate.updateData[lastUpdate.updateType.type]['message_id'], Closure action) {
		api.defaultParams << [reply_to_message_id: replyTo]
		action.call()
		api.defaultParams.remove('reply_to_message_id')
	}
}