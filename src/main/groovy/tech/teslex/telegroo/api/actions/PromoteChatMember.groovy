package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait PromoteChatMember {

	def promoteChatMember(Map params = [:]) {
		promoteChatMember(lastUpdate.message.from.id, lastUpdate.message.chat.id, params)
	}

	def promoteChatMember(userId, chatId, Map params = [:]) {
		api.go(new Some('promoteChatMember', [chat_id: chatId, user_id: userId] + params))
	}
}