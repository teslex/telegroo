package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some
import tech.teslex.telegroo.api.telegram.types.Message

@CompileStatic
trait SendContact extends AbstractContext {

	Message sendContact(phoneNumber, firstName, Map params = [:]) {
		sendContact(phoneNumber.toString(), firstName.toString(), lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'])
	}

	Message sendContact(phoneNumber, firstName, chatId, Map params = [:]) {
		def result = api.go(new Some('sendContact', [chat_id: chatId, phone_number: phoneNumber.toString(), first_name: firstName.toString()] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}
}
