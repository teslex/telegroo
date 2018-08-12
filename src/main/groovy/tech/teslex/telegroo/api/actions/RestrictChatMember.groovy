package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait RestrictChatMember {

	def restrictChatMember(Map params = [:]) {
		restrictChatMember(lastUpdate.message.from.id, lastUpdate.message.chat.id, params)
	}

	def restrictChatMember(userId, chatId, Map params = [:]) {
		api.go(new Some('restrictChatMember', [chat_id: chatId, user_id: userId] + params))
	}
}
