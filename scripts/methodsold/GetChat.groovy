package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some
import tech.teslex.telegroo.api.telegram.types.Chat

@CompileStatic
trait GetChat extends AbstractContext {

	Chat getChat(chatId = lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], Map params = [:]) {
		def result = api.go(new Some('getChat', [chat_id: chatId] + params))['result'] as Map
		return m2c2m(result, Chat) as Chat
	}
}
