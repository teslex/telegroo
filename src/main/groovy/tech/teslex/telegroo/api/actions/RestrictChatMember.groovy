package tech.teslex.telegroo.api.actions

trait RestrictChatMember {

	def restrictChatMember(Map params = [:]) {
		restrictChatMember(lastUpdate.message.from.id, lastUpdate.message.chat.id, params)
	}

	def restrictChatMember(userId, chatId, Map params = [:]) {
		api.go('restrictChatMember', [chat_id: chatId, user_id: userId] + params)
	}
}
