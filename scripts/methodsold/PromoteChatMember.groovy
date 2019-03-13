package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait PromoteChatMember extends AbstractContext {

	def promoteChatMember(Map params = [:]) {
		promoteChatMember(lastUpdate.updateData[lastUpdate.updateType.type]['from']['id'], lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	def promoteChatMember(userId, chatId, Map params = [:]) {
		api.go(new Some('promoteChatMember', [chat_id: chatId, user_id: userId] + params))
	}
}