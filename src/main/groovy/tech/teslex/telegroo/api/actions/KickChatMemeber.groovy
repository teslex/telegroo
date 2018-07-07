package tech.teslex.telegroo.api.actions

trait KickChatMemeber {

	def kickChatMember(Map params = [:]) {
		kickChatMember(lastUpdate.message.from.id,lastUpdate.message.chat.id,params)
	}

	def kickChatMember(userId, chatId, Map params = [:]) {
		api.go('kickChatMember', [chat_id: chatId, user_id: userId] + params)
	}
}
