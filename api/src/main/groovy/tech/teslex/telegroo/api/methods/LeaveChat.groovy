package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait LeaveChat {

	def leaveChat(chatId = lastUpdate.updateData[lastUpdate.updateType].chat.id, Map params = [:]) {
		api.go(new Some('leaveChat', [chat_id: chatId] + params))
	}
}
