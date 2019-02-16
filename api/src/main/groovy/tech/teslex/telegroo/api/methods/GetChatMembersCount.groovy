package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait GetChatMembersCount {

	def getChatMembersCount(chatId = lastUpdate.updateData[lastUpdate.updateType].chat.id, Map params = [:]) {
		api.go(new Some('getChatMembersCount', [chat_id: chatId] + params))
	}
}
