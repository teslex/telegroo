package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some
import tech.teslex.telegroo.api.telegram.types.Message


@CompileStatic
trait SendMessage extends AbstractContext {

	Message sendMessage(text, Map params = [:]) {
		sendMessage(text.toString(), lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	@NamedVariant
	def sendMessage(text, chatId, Map params = [:]) {
		def result = api.go(new Some('sendMessage', [chat_id: chatId, text: text.toString()] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}
}
