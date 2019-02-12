package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.some.Some

trait Forward {

	def forward(Map params = [:]) {
		forward(lastUpdate.updateData.message.chat.id, lastUpdate.updateData.message.message_id, lastUpdate.updateData.message.chat.id, params)
	}

	def forward(fromChatId, messageId, chatId, Map params = [:]) {
		api.go(new Some('forwardMessage', [chat_id: chatId, from_chat_id: fromChatId, message_id: messageId] + params))
	}
}
