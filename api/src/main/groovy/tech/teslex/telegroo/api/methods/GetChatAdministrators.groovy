package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait GetChatAdministrators {
	
	def getChatAdministrators(chatId = lastUpdate.updateData[lastUpdate.updateType].chat.id, Map params = [:]) {
		api.go(new Some('getChatAdministrators', [chat_id: chatId] + params))
	}
}
