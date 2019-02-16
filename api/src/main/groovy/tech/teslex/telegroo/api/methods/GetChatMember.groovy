package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait GetChatMember {

	def getChatMember(Map params = [:]) {
		getChatMember(lastUpdate.updateData[lastUpdate.updateType].from.id, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def getChatMember(userId, Map params = [:]) {
		getChatMember(userId, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def getChatMember(userId, chatId, Map params = [:]) {
		api.go(new Some('getChatMember', [chat_id: chatId, user_id: userId] + params))
	}
}
