package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait Forward {

	def forward(Map params = [:]) {
		forward(lastUpdate.message.chat.id, lastUpdate.message.message_id, lastUpdate.message.chat.id, params)
	}

	def forward(fromChatId, messageId, chatId, Map params = [:]) {
		api.go(new Some('forwardMessage', [chat_id: chatId, from_chat_id: fromChatId, message_id: messageId] + params))
	}
}
