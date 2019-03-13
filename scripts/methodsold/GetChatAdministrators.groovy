package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some
import tech.teslex.telegroo.api.telegram.types.ChatMember

@CompileStatic
trait GetChatAdministrators extends AbstractContext {

	List<ChatMember> getChatAdministrators(chatId = lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], Map params = [:]) {
		def result = api.go(new Some('getChatAdministrators', [chat_id: chatId] + params))['result'] as List<Map>
		return result.collect { m2c2m(it, ChatMember) as ChatMember }
	}
}
