package tech.teslex.telegroo.api

import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

@CompileStatic
trait Actions {
	def getMe() {
		api.go('getMe')
	}

	@CompileDynamic
	def sendMessage(def chatId = lastUpdate.message.chat.id, String message, Map params = [:]) {
		api.go('sendMessage', [chat_id: chatId, text: message] + params)
	}

	@CompileDynamic
	def forward(
			def fromChatId = lastUpdate.message.chat.id,
			def messageId = lastUpdate.message.message_id, def chatId = lastUpdate.message.chat.id, Map params = [:]) {
		api.go('forwardMessage', [chat_id: chatId, from_chat_id: fromChatId, message_id: messageId] + params)
	}

	@CompileDynamic
	def reply(
			def chatId = lastUpdate.message.chat.id,
			def replyTo = lastUpdate.message.message_id, String message, Map params = [:]) {
		sendMessage(chatId, message, [reply_to_message_id: replyTo] + params)
	}

	@CompileDynamic
	def sendPhoto(def chatId = lastUpdate.message.chat.id, File photo, Map params = [:]) {
		api.goWithFile('sendPhoto', photo, 'photo', [chat_id: chatId] + params)
	}

	@CompileDynamic
	def sendPhoto(def chatId = lastUpdate.message.chat.id, String photo, Map params = [:]) {
		api.go('sendPhoto', [chat_id: chatId, photo: photo] + params)
	}

	@CompileDynamic
	def sendPhotoId(def chatId = lastUpdate.message.chat.id, String photoId, Map params = [:]) {
		api.go('sendPhoto', [chat_id: chatId, photo: [file_id: photoId]] + params)
	}


	@CompileDynamic
	def sendAudio(def chatId = lastUpdate.message.chat.id, File audio, Map params = [:]) {
		api.goWithFile('sendAudio', audio, 'audio', [chat_id: chatId] + params)
	}

	@CompileDynamic
	def sendAudio(def chatId = lastUpdate.message.chat.id, String audio, Map params = [:]) {
		api.go('sendAudio', [chat_id: chatId, audio: audio] + params)
	}

	@CompileDynamic
	def sendAudioId(def chatId = lastUpdate.message.chat.id, String audioId, Map params = [:]) {
		api.go('sendAudio', [chat_id: chatId, audio: [file_id: audioId]] + params)
	}


	@CompileDynamic
	def sendDocument(def chatId = lastUpdate.message.chat.id, File document, Map params = [:]) {
		api.goWithFile('sendDocument', document, 'document', [chat_id: chatId] + params)
	}

	@CompileDynamic
	def sendDocument(def chatId = lastUpdate.message.chat.id, String document, Map params = [:]) {
		api.go('sendDocument', [chat_id: chatId, document: document] + params)
	}

	@CompileDynamic
	def sendDocumentId(def chatId = lastUpdate.message.chat.id, String documentId, Map params = [:]) {
		api.go('sendDocument', [chat_id: chatId, document: [file_id: documentId]] + params)
	}


	@CompileDynamic
	def sendSticker(def chatId = lastUpdate.message.chat.id, File sticker, Map params = [:]) {
		api.goWithFile('sendSticker', sticker, 'sticker', [chat_id: chatId] + params)
	}

	@CompileDynamic
	def sendSticker(def chatId = lastUpdate.message.chat.id, String sticker, Map params = [:]) {
		api.go('sendSticker', [chat_id: chatId, sticker: sticker] + params)
	}

	@CompileDynamic
	def sendStickerId(def chatId = lastUpdate.message.chat.id, String stickerId, Map params = [:]) {
		api.go('sendSticker', [chat_id: chatId, sticker: [file_id: stickerId]] + params)
	}


	@CompileDynamic
	def sendVideo(def chatId = lastUpdate.message.chat.id, File video, Map params = [:]) {
		api.goWithFile('sendVideo', video, 'video', [chat_id: chatId] + params)
	}

	@CompileDynamic
	def sendVideo(def chatId = lastUpdate.message.chat.id, String video, Map params = [:]) {
		api.go('sendVideo', [chat_id: chatId, video: video] + params)
	}

	@CompileDynamic
	def sendVideoId(def chatId = lastUpdate.message.chat.id, String videoId, Map params = [:]) {
		api.go('sendVideo', [chat_id: chatId, video: [file_id: videoId]] + params)
	}


	@CompileDynamic
	def sendVoice(def chatId = lastUpdate.message.chat.id, File voice, Map params = [:]) {
		api.goWithFile('sendVoice', voice, 'voice', [chat_id: chatId] + params)
	}

	@CompileDynamic
	def sendVoice(def chatId = lastUpdate.message.chat.id, String voice, Map params = [:]) {
		api.go('sendVoice', [chat_id: chatId, voice: voice] + params)
	}

	@CompileDynamic
	def sendVoiceId(def chatId = lastUpdate.message.chat.id, String voiceId, Map params = [:]) {
		api.go('sendVoice', [chat_id: chatId, voice: [file_id: voiceId]] + params)
	}


	@CompileDynamic
	def sendLocation(def chatId = lastUpdate.message.chat.id, float latitude, float longitude, Map params = [:]) {
		api.go('sendLocation', [chat_id: chatId, latitude: latitude, longitude: longitude] + params)
	}

	@CompileDynamic
	def sendVenue(
			def chatId = lastUpdate.message.chat.id, float latitude, float longitude, String title, String address, Map params = [:]) {
		api.go('sendVenue', [chat_id: chatId, latitude: latitude, longitude: longitude, title: title, address: address] + params)
	}

	@CompileDynamic
	def sendContact(def chatId = lastUpdate.message.chat.id, String phoneNumber, String firstName, Map params = [:]) {
		api.go('sendContact', [chat_id: chatId, phone_number: phoneNumber, first_name: firstName] + params)
	}

	@CompileDynamic
	def sendChatAction(def chatId = lastUpdate.message.chat.id, String action, Map params = [:]) {
		api.go('sendChatAction', [chat_id: chatId, action: action] + params)
	}

	@CompileDynamic
	def getUserProfilePhotos(def userId = lastUpdate.message.from.id, Map params = [:]) {
		api.go('getUserProfilePhotos', [user_id: userId] + params)
	}

	@CompileDynamic
	def getFile(def fileId, Map params = [:]) {
		api.go('getFile', [file_id: fileId] + params)
	}

	@CompileDynamic
	def kickChatMember(
			def chatId = lastUpdate.message.chat.id, def userId = lastUpdate.message.from.id, Map params = [:]) {
		api.go('kickChatMember', [chat_id: chatId, user_id: userId] + params)
	}

	@CompileDynamic
	def unbanChatMember(
			def chatId = lastUpdate.message.chat.id, def userId = lastUpdate.message.from.id, Map params = [:]) {
		api.go('unbanChatMember', [chat_id: chatId, user_id: userId] + params)
	}

	@CompileDynamic
	def answerCallbackQuery(def callbackQueryId = lastUpdate.message.chat.id, Map params = [:]) {
		api.go('answerCallbackQuery', [callback_query_id: callbackQueryId] + params)
	}

	@CompileDynamic
	def editMessageText(def chatId = lastUpdate.message.chat.id, int messageId, String text, Map params = [:]) {
		api.go('editMessageText', [chat_id: chatId, message_id: messageId, text: text] + params)
	}

	@CompileDynamic
	def editMessageCaption(
			def chatId = lastUpdate.message.chat.id, int messageId, String caption = '', Map params = [:]) {
		api.go('editMessageCaption', [chat_id: chatId, message_id: messageId, caption: caption] + params)
	}

	@CompileDynamic
	def editMessageReplyMarkup(
			def chatId = lastUpdate.message.chat.id, int messageId, Map replyMarkup = [:], Map params = [:]) {
		api.go('editMessageReplyMarkup', [chat_id: chatId, message_id: messageId, reply_markup: replyMarkup] + params)
	}

	// small hack :)
	Api getApi() {
		return api
	}
}