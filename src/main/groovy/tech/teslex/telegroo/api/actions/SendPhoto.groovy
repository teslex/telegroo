package tech.teslex.telegroo.api.actions

trait SendPhoto {

	def sendPhoto(File photo, Map params = [:]) {
		sendPhoto(photo, lastUpdate.message.chat.id, params)
	}

	def sendPhoto(String photo, Map params = [:]) {
		sendPhoto(photo, lastUpdate.message.chat.id, params)
	}

	def sendPhotoId(String photoId, Map params = [:]) {
		sendPhotoId(photoId, lastUpdate.message.chat.id, params)
	}

	def sendPhoto(File photo, chatId, Map params = [:]) {
		api.goWithFile('sendPhoto', photo, 'photo', [chat_id: chatId] + params)
	}

	def sendPhoto(String photo, chatId, Map params = [:]) {
		api.go('sendPhoto', [chat_id: chatId, photo: photo] + params)
	}

	def sendPhotoId(String photoId, chatId, Map params = [:]) {
		api.go('sendPhoto', [chat_id: chatId, photo: [file_id: photoId]] + params)
	}
}