package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait KickChatMember {

	def kickChatMember(Map params = [:]) {
		kickChatMember(lastUpdate.updateData[lastUpdate.updateType].from.id, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def kickChatMember(userId, chatId, Map params = [:]) {
		api.go(new Some('kickChatMember', [chat_id: chatId, user_id: userId] + params))
	}
}
