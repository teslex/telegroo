package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.some.SomeFile

trait SetChatPhoto {

	def setChatPhoto(File photo, Map params = [:]) {
		setChatPhoto(photo, lastUpdate.updateData.message.chat.id)
	}

	def setChatPhoto(File photo, chatId, Map params = [:]) {
		api.goWithFile(new SomeFile('setChatPhoto', 'photo', photo, [chat_id: chatId] + params))
	}
}