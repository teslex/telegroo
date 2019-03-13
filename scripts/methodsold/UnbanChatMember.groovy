package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait UnbanChatMember extends AbstractContext {

	def unbanChatMember(Map params = [:]) {
		unbanChatMember(lastUpdate.updateData[lastUpdate.updateType.type]['from']['id'], lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	def unbanChatMember(userId, chatId, Map params = [:]) {
		api.go(new Some('unbanChatMember', [chat_id: chatId, user_id: userId] + params))
	}
}
