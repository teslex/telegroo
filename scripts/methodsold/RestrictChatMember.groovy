package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait RestrictChatMember extends AbstractContext {

	def restrictChatMember(Map params = [:]) {
		restrictChatMember(lastUpdate.updateData[lastUpdate.updateType.type]['from']['id'], lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	def restrictChatMember(userId, chatId, Map params = [:]) {
		api.go(new Some('restrictChatMember', [chat_id: chatId, user_id: userId] + params))
	}
}
