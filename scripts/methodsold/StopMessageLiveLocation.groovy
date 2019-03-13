package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait StopMessageLiveLocation extends AbstractContext {

	def stopMessageLiveLocation(int messageId, Map params = [:]) {
		stopMessageLiveLocation(messageId, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	def stopMessageLiveLocation(int messageId, chatId, Map params = [:]) {
		api.go(new Some('stopMessageLiveLocation', [chat_id: chatId, message_id: messageId] + params))
	}
}
