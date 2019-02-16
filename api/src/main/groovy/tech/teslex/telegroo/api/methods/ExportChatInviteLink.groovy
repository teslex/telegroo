package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait ExportChatInviteLink {

	def exportChatInviteLink(Map params = [:]) {
		exportChatInviteLink(lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def exportChatInviteLink(chatId, Map params = [:]) {
		api.go(new Some('exportChatInviteLink', [chat_id: chatId] + params))
	}
}