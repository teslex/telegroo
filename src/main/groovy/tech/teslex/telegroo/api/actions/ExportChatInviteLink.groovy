package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait ExportChatInviteLink {

	def exportChatInviteLink(Map params = [:]) {
		exportChatInviteLink(lastUpdate.message.chat.id, params)
	}

	def exportChatInviteLink(chatId, Map params = [:]) {
		api.go(new Some('exportChatInviteLink', [chat_id: chatId] + params))
	}
}