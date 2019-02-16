package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait PromoteChatMember {

	def promoteChatMember(Map params = [:]) {
		promoteChatMember(lastUpdate.updateData[lastUpdate.updateType].from.id, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def promoteChatMember(userId, chatId, Map params = [:]) {
		api.go(new Some('promoteChatMember', [chat_id: chatId, user_id: userId] + params))
	}
}