package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait GetChat {
	
	def getChat(chatId = lastUpdate.updateData[lastUpdate.updateType].chat.id, Map params = [:]) {
		api.go(new Some('getChat', [chat_id: chatId] + params))
	}
}
