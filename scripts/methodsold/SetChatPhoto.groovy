package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.SomeFile

@CompileStatic
trait SetChatPhoto extends AbstractContext {

	def setChatPhoto(File photo, Map params = [:]) {
		setChatPhoto(photo, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'])
	}

	def setChatPhoto(File photo, chatId, Map params = [:]) {
		api.go(new SomeFile('setChatPhoto', 'photo', photo, [chat_id: chatId] + params))
	}
}