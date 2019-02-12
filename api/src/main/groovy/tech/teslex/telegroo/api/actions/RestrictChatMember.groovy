package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.some.Some

trait RestrictChatMember {

	def restrictChatMember(Map params = [:]) {
		restrictChatMember(lastUpdate.updateData.message.from.id, lastUpdate.updateData.message.chat.id, params)
	}

	def restrictChatMember(userId, chatId, Map params = [:]) {
		api.go(new Some('restrictChatMember', [chat_id: chatId, user_id: userId] + params))
	}
}
