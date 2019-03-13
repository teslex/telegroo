package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait SetChatTitle extends AbstractContext {

	def setChatTitle(title, Map params = [:]) {
		setChatTitle(title.toString(), lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	def setChatTitle(title, chatId, Map params = [:]) {
		api.go(new Some('setChatTitle', [chat_id: chatId, title: title.toString()] + params))
	}
}