package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait KickChatMember extends AbstractContext {

	def kickChatMember(Map params = [:]) {
		kickChatMember(lastUpdate.updateData[lastUpdate.updateType.type]['from']['id'], lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	def kickChatMember(userId, chatId, Map params = [:]) {
		api.go(new Some('kickChatMember', [chat_id: chatId, user_id: userId] + params))
	}
}
