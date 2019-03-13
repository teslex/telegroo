package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some
import tech.teslex.telegroo.api.telegram.types.Message

@CompileStatic
trait SendLocation extends AbstractContext {

	Message sendLocation(latitude, longitude, Map params = [:]) {
		sendLocation(latitude, longitude, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'])
	}

	Message sendLocation(latitude, longitude, chatId, Map params = [:]) {
		def result = api.go(new Some('sendLocation', [chat_id: chatId, latitude: latitude, longitude: longitude] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}
}
