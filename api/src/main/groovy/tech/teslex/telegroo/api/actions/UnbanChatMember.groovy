package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.some.Some

trait UnbanChatMember {

	def unbanChatMember(Map params = [:]) {
		unbanChatMember(lastUpdate.updateData.message.from.id, lastUpdate.updateData.message.chat.id, params)
	}

	def unbanChatMember(userId, chatId, Map params = [:]) {
		api.go(new Some('unbanChatMember', [chat_id: chatId, user_id: userId] + params))
	}
}
