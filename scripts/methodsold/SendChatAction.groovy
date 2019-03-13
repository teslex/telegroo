package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.enums.ChatAction
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait SendChatAction extends AbstractContext {

	def sendChatAction(action, Map params = [:]) {
		sendChatAction(action.toString(), lastUpdate.updateData[lastUpdate.updateType.type]['from']['id'], params)
	}

	def sendChatAction(ChatAction chatAction, Map params = [:]) {
		sendChatAction(chatAction.action, lastUpdate.updateData[lastUpdate.updateType.type]['from']['id'], params)
	}

	def sendChatAction(ChatAction chatAction, chatId, Map params = [:]) {
		sendChatAction(chatAction.action, chatId, params)
	}

	def sendChatAction(action, chatId, Map params = [:]) {
		api.go(new Some('sendChatAction', [chat_id: chatId, action: action.toString()] + params))
	}
}
