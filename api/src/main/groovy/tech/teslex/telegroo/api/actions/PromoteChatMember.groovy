package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.some.Some

trait PromoteChatMember {

	def promoteChatMember(Map params = [:]) {
		promoteChatMember(lastUpdate.updateData.message.from.id, lastUpdate.updateData.message.chat.id, params)
	}

	def promoteChatMember(userId, chatId, Map params = [:]) {
		api.go(new Some('promoteChatMember', [chat_id: chatId, user_id: userId] + params))
	}
}