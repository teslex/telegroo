package tech.teslex.telegroo.api.actions

trait UnbanChatMember {

	def unbanChatMember(Map params = [:]) {
		unbanChatMember(lastUpdate.message.from.id, lastUpdate.message.chat.id, params)
	}

	def unbanChatMember(userId, chatId, Map params = [:]) {
		api.go('unbanChatMember', [chat_id: chatId, user_id: userId] + params)
	}
}
