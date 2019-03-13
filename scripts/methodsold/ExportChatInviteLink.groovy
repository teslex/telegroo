package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait ExportChatInviteLink extends AbstractContext {

	def exportChatInviteLink(Map params = [:]) {
		exportChatInviteLink(lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	def exportChatInviteLink(chatId, Map params = [:]) {
		api.go(new Some('exportChatInviteLink', [chat_id: chatId] + params))
	}
}