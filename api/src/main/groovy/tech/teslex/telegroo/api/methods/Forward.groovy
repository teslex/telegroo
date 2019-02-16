package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait Forward {

	def forward(Map params = [:]) {
		forward(lastUpdate.updateData[lastUpdate.updateType].chat.id, lastUpdate.updateData[lastUpdate.updateType].message_id, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def forward(chatId, Map params = [:]) {
		forward(lastUpdate.updateData[lastUpdate.updateType].chat.id, lastUpdate.updateData[lastUpdate.updateType].message_id, chatId, params)
	}

	def forward(fromChatId, messageId, chatId, Map params = [:]) {
		api.go(new Some('forwardMessage', [chat_id: chatId, from_chat_id: fromChatId, message_id: messageId] + params))
	}
}
