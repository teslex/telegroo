package tech.teslex.telegroo.api.actions

trait PromoteChatMember {

	def promoteChatMember(Map params = [:]) {
		promoteChatMember(lastUpdate.message.from.id, lastUpdate.message.chat.id, params)
	}

	def promoteChatMember(userId, chatId, Map params = [:]) {
		api.go('promoteChatMember', [chat_id: chatId, user_id: userId] + params)
	}
}