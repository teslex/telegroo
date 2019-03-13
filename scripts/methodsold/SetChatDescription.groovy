package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait SetChatDescription extends AbstractContext {

	def setChatDescription(String description, Map params = [:]) {
		setChatDescription(description, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'])
	}

	def setChatDescription(String description, chatId, Map params = [:]) {
		api.go(new Some('setChatTitle', [chat_id: chatId, description: description] + params))
	}
}