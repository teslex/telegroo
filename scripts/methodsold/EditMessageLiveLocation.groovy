package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait EditMessageLiveLocation extends AbstractContext {

	def editMessageLiveLocation(messageId, latitude, longitude, Map params = [:]) {
		editMessageLiveLocation(messageId, latitude, longitude, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	def editMessageLiveLocation(messageId, latitude, longitude, chatId, Map params = [:]) {
		api.go(new Some('editMessageLiveLocation', [chat_id: chatId, message_id: messageId, latitude: latitude, longitude: longitude] + params))
	}
}
