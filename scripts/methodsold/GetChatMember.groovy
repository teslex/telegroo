package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some
import tech.teslex.telegroo.api.telegram.types.ChatMember

@CompileStatic
trait GetChatMember extends AbstractContext {

	ChatMember getChatMember(Map params = [:]) {
		getChatMember(lastUpdate.updateData[lastUpdate.updateType.type]['from']['id'], lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	ChatMember getChatMember(userId, Map params = [:]) {
		getChatMember(userId, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	ChatMember getChatMember(userId, chatId, Map params = [:]) {
		def result = api.go(new Some('getChatMember', [chat_id: chatId, user_id: userId] + params))['result'] as Map
		return m2c2m(result, ChatMember) as ChatMember
	}
}
