package tech.teslex.telegroo.api.actions

trait ExportChatInviteLink {

	def exportChatInviteLink(Map params = [:]) {
		exportChatInviteLink(lastUpdate.message.chat.id, params)
	}

	def exportChatInviteLink(chatId, Map params = [:]) {
		api.go('exportChatInviteLink', [chat_id: chatId] + params)
	}
}