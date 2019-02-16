package tech.teslex.telegroo.api.methods


import tech.teslex.telegroo.api.some.Some

trait UnbanChatMember {

	def unbanChatMember(Map params = [:]) {
		unbanChatMember(lastUpdate.updateData[lastUpdate.updateType].from.id, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def unbanChatMember(userId, chatId, Map params = [:]) {
		api.go(new Some('unbanChatMember', [chat_id: chatId, user_id: userId] + params))
	}
}
