package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait KickChatMemeber {

	def kickChatMember(Map params = [:]) {
		kickChatMember(lastUpdate.message.from.id,lastUpdate.message.chat.id,params)
	}

	def kickChatMember(userId, chatId, Map params = [:]) {
		api.go(new Some('kickChatMember', [chat_id: chatId, user_id: userId] + params))
	}
}
