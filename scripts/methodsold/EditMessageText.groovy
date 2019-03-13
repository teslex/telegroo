package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait EditMessageText extends AbstractContext {

	def editMessageText(messageId, text, Map params = [:]) {
		editMessageText(messageId, text.toString(), lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	def editMessageText(messageId, text, chatId, Map params = [:]) {
		api.go(new Some('editMessageText', [chat_id: chatId, message_id: messageId, text: text.toString()] + params))
	}
}
