package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait DeleteChatPhoto extends AbstractContext {

	def deleteChatPhoto(Map params = [:]) {
		deleteChatPhoto(lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	def deleteChatPhoto(chatId, Map params = [:]) {
		api.go(new Some('deleteChatPhoto', [chat_id: chatId] + params))
	}
}