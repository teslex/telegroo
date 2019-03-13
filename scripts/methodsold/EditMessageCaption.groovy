package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait EditMessageCaption extends AbstractContext {

	def editMessageCaption(messageId, caption = '', Map params = [:]) {
		editMessageCaption(messageId, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], caption.toString(), params)
	}

	def editMessageCaption(messageId, chatId, caption, Map params = [:]) {
		api.go(new Some('editMessageCaption', [chat_id: chatId, message_id: messageId, caption: caption.toString()] + params))
	}
}
