package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait GetChatMembersCount extends AbstractContext {

	def getChatMembersCount(chatId = lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], Map params = [:]) {
		api.go(new Some('getChatMembersCount', [chat_id: chatId] + params))
	}
}