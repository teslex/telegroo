package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some
import tech.teslex.telegroo.api.some.SomePhoto

trait SendPhoto {

	def sendPhoto(File photo, String caption = '', Map params = [:]) {
		sendPhoto(photo, caption, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def sendPhoto(String photo, String caption = '', Map params = [:]) {
		sendPhoto(photo, caption, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def sendPhotoId(String photoId, String caption = '', Map params = [:]) {
		sendPhotoId(photoId, caption, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def sendPhoto(File photo, String caption = '', chatId, Map params = [:]) {
		api.go(new SomePhoto(caption, photo, [chat_id: chatId] + params))
	}

	def sendPhoto(String photo, String caption = '', chatId, Map params = [:]) {
		if (caption)
			params += [caption: caption]
		api.go(new Some('sendPhoto', [chat_id: chatId, photo: photo] + params))
	}

	def sendPhotoId(String photoId, String caption = '', chatId, Map params = [:]) {
		if (caption)
			params += [caption: caption]
		api.go(new Some('sendPhoto', [chat_id: chatId, photo: [file_id: photoId]] + params))
	}
}