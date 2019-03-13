package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some
import tech.teslex.telegroo.api.telegram.types.Message

@CompileStatic
trait SendVenue extends AbstractContext {

	Message sendVenue(float latitude, float longitude, String title, String address, Map params = [:]) {
		sendVenue(latitude, longitude, title, address, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	Message sendVenue(float latitude, float longitude, String title, String address, chatId, Map params = [:]) {
		def result = api.go(new Some('sendVenue', [chat_id: chatId, latitude: latitude, longitude: longitude, title: title, address: address] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}
}