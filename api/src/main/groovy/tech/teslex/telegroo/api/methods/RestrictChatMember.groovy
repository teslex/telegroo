package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait RestrictChatMember {

	def restrictChatMember(Map params = [:]) {
		restrictChatMember(lastUpdate.updateData[lastUpdate.updateType].from.id, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def restrictChatMember(userId, chatId, Map params = [:]) {
		api.go(new Some('restrictChatMember', [chat_id: chatId, user_id: userId] + params))
	}
}
