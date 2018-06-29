package tech.teslex.telegroo.api

trait Actions {
	def getMe() {
		api.go('getMe')
	}

	/* --- sendMessage ---*/

	def sendMessage(String message, Map params = [:]) {
		api.go('sendMessage', [chat_id: lastUpdate.message.chat.id, text: message] + params)
	}

	def sendMessage(def chatId, String message, Map params = [:]) {
		api.go('sendMessage', [chat_id: chatId, text: message] + params)
	}

	/* --- forward ---*/

	def forward(Map params = [:]) {
		api.go('forwardMessage', [chat_id: lastUpdate.message.chat.id, from_chat_id: lastUpdate.message.chat.id, message_id: lastUpdate.message.message_id] + params)
	}

	def forward(def fromChatId, def messageId, def chatId, Map params = [:]) {
		api.go('forwardMessage', [chat_id: chatId, from_chat_id: fromChatId, message_id: messageId] + params)
	}

	def reply(String message, Map params = [:]) {
		sendMessage(lastUpdate.message.chat.id, message, [reply_to_message_id: lastUpdate.message.message_id] + params)
	}

	def reply(def chatId, def replyTo, String message, Map params = [:]) {
		sendMessage(chatId, message, [reply_to_message_id: replyTo] + params)
	}

	/* --- sendPhoto ---*/

	def sendPhoto(File photo, Map params = [:]) {
		api.goWithFile('sendPhoto', photo, 'photo', [chat_id: lastUpdate.message.chat.id] + params)
	}

	def sendPhoto(String photo, Map params = [:]) {
		api.go('sendPhoto', [chat_id: lastUpdate.message.chat.id, photo: photo] + params)
	}

	def sendPhotoId(String photoId, Map params = [:]) {
		api.go('sendPhoto', [chat_id: lastUpdate.message.chat.id, photo: [file_id: photoId]] + params)
	}

	def sendPhoto(def chatId, File photo, Map params = [:]) {
		api.goWithFile('sendPhoto', photo, 'photo', [chat_id: chatId] + params)
	}

	def sendPhoto(def chatId, String photo, Map params = [:]) {
		api.go('sendPhoto', [chat_id: chatId, photo: photo] + params)
	}

	def sendPhotoId(def chatId, String photoId, Map params = [:]) {
		api.go('sendPhoto', [chat_id: chatId, photo: [file_id: photoId]] + params)
	}

	/* --- sendAudio ---*/

	def sendAudio(File audio, Map params = [:]) {
		api.goWithFile('sendAudio', audio, 'audio', [chat_id: lastUpdate.message.chat.id] + params)
	}

	def sendAudio(String audio, Map params = [:]) {
		api.go('sendAudio', [chat_id: lastUpdate.message.chat.id, audio: audio] + params)
	}

	def sendAudioId(String audioId, Map params = [:]) {
		api.go('sendAudio', [chat_id: lastUpdate.message.chat.id, audio: [file_id: audioId]] + params)
	}

	def sendAudio(def chatId, File audio, Map params = [:]) {
		api.goWithFile('sendAudio', audio, 'audio', [chat_id: chatId] + params)
	}

	def sendAudio(def chatId, String audio, Map params = [:]) {
		api.go('sendAudio', [chat_id: chatId, audio: audio] + params)
	}

	def sendAudioId(def chatId, String audioId, Map params = [:]) {
		api.go('sendAudio', [chat_id: chatId, audio: [file_id: audioId]] + params)
	}


	/* --- sendDocument ---*/

	def sendDocument(File document, Map params = [:]) {
		api.goWithFile('sendDocument', document, 'document', [chat_id: lastUpdate.message.chat.id] + params)
	}

	def sendDocument(String document, Map params = [:]) {
		api.go('sendDocument', [chat_id: lastUpdate.message.chat.id, document: document] + params)
	}

	def sendDocumentId(String documentId, Map params = [:]) {
		api.go('sendDocument', [chat_id: lastUpdate.message.chat.id, document: [file_id: documentId]] + params)
	}

	def sendDocument(def chatId, File document, Map params = [:]) {
		api.goWithFile('sendDocument', document, 'document', [chat_id: chatId] + params)
	}

	def sendDocument(def chatId, String document, Map params = [:]) {
		api.go('sendDocument', [chat_id: chatId, document: document] + params)
	}

	def sendDocumentId(def chatId, String documentId, Map params = [:]) {
		api.go('sendDocument', [chat_id: chatId, document: [file_id: documentId]] + params)
	}


	/* --- sendSticker ---*/

	def sendSticker(File sticker, Map params = [:]) {
		api.goWithFile('sendSticker', sticker, 'sticker', [chat_id: lastUpdate.message.chat.id] + params)
	}

	def sendSticker(String sticker, Map params = [:]) {
		api.go('sendSticker', [chat_id: lastUpdate.message.chat.id, sticker: sticker] + params)
	}

	def sendStickerId(String stickerId, Map params = [:]) {
		api.go('sendSticker', [chat_id: lastUpdate.message.from.id, sticker: [file_id: stickerId]] + params)
	}

	def sendSticker(def chatId, File sticker, Map params = [:]) {
		api.goWithFile('sendSticker', sticker, 'sticker', [chat_id: chatId] + params)
	}

	def sendSticker(def chatId, String sticker, Map params = [:]) {
		api.go('sendSticker', [chat_id: chatId, sticker: sticker] + params)
	}

	def sendStickerId(def chatId, String stickerId, Map params = [:]) {
		api.go('sendSticker', [chat_id: chatId, sticker: [file_id: stickerId]] + params)
	}


	/* --- sendVideo ---*/

	def sendVideo(File video, Map params = [:]) {
		api.goWithFile('sendVideo', video, 'video', [chat_id: lastUpdate.message.chat.id] + params)
	}

	def sendVideo(String video, Map params = [:]) {
		api.go('sendVideo', [chat_id: lastUpdate.message.chat.id, video: video] + params)
	}

	def sendVideoId(String videoId, Map params = [:]) {
		api.go('sendVideo', [chat_id: lastUpdate.message.chat.id, video: [file_id: videoId]] + params)
	}

	def sendVideo(def chatId, File video, Map params = [:]) {
		api.goWithFile('sendVideo', video, 'video', [chat_id: chatId] + params)
	}

	def sendVideo(def chatId, String video, Map params = [:]) {
		api.go('sendVideo', [chat_id: chatId, video: video] + params)
	}

	def sendVideoId(def chatId, String videoId, Map params = [:]) {
		api.go('sendVideo', [chat_id: chatId, video: [file_id: videoId]] + params)
	}


	/* --- sendVoice ---*/

	def sendVoice(File voice, Map params = [:]) {
		api.goWithFile('sendVoice', voice, 'voice', [chat_id: lastUpdate.message.chat.id] + params)
	}

	def sendVoice(String voice, Map params = [:]) {
		api.go('sendVoice', [chat_id: lastUpdate.message.chat.id, voice: voice] + params)
	}

	def sendVoiceId(String voiceId, Map params = [:]) {
		api.go('sendVoice', [chat_id: lastUpdate.message.chat.id, voice: [file_id: voiceId]] + params)
	}

	def sendVoice(def chatId, File voice, Map params = [:]) {
		api.goWithFile('sendVoice', voice, 'voice', [chat_id: chatId] + params)
	}

	def sendVoice(def chatId, String voice, Map params = [:]) {
		api.go('sendVoice', [chat_id: chatId, voice: voice] + params)
	}

	def sendVoiceId(def chatId, String voiceId, Map params = [:]) {
		api.go('sendVoice', [chat_id: chatId, voice: [file_id: voiceId]] + params)
	}


	/* --- sendLocation ---*/

	def sendLocation(float latitude, float longitude, Map params = [:]) {
		api.go('sendLocation', [chat_id: lastUpdate.message.chat.id, latitude: latitude, longitude: longitude] + params)
	}

	def sendLocation(def chatId, float latitude, float longitude, Map params = [:]) {
		api.go('sendLocation', [chat_id: chatId, latitude: latitude, longitude: longitude] + params)
	}

	/* --- sendVenue ---*/

	def sendVenue(float latitude, float longitude, String title, String address, Map params = [:]) {
		api.go('sendVenue', [chat_id: lastUpdate.message.chat.id, latitude: latitude, longitude: longitude, title: title, address: address] + params)
	}

	def sendVenue(def chatId, float latitude, float longitude, String title, String address, Map params = [:]) {
		api.go('sendVenue', [chat_id: chatId, latitude: latitude, longitude: longitude, title: title, address: address] + params)
	}

	/* --- sendContact ---*/

	def sendContact(String phoneNumber, String firstName, Map params = [:]) {
		api.go('sendContact', [chat_id: lastUpdate.message.chat.id, phone_number: phoneNumber, first_name: firstName] + params)
	}

	def sendContact(def chatId, String phoneNumber, String firstName, Map params = [:]) {
		api.go('sendContact', [chat_id: chatId, phone_number: phoneNumber, first_name: firstName] + params)
	}

	/* --- sendChatAction ---*/

	def sendChatAction(String action, Map params = [:]) {
		api.go('sendChatAction', [chat_id: lastUpdate.message.from.id, action: action] + params)
	}

	def sendChatAction(def chatId, String action, Map params = [:]) {
		api.go('sendChatAction', [chat_id: chatId, action: action] + params)
	}

	/* --- getUserProfilePhotos ---*/

	def getUserProfilePhotos(def userId = lastUpdate.message.from.id, Map params = [:]) {
		api.go('getUserProfilePhotos', [user_id: userId] + params)
	}

	/* --- getFile ---*/

	def getFile(def fileId, Map params = [:]) {
		api.go('getFile', [file_id: fileId] + params)
	}

	/* --- kickChatMember ---*/

	def kickChatMember(Map params = [:]) {
		api.go('kickChatMember', [chat_id: lastUpdate.message.chat.id, user_id: lastUpdate.message.from.id] + params)
	}

	def kickChatMember(def chatId, def userId, Map params = [:]) {
		api.go('kickChatMember', [chat_id: chatId, user_id: userId] + params)
	}

	/* --- unbanChatMember ---*/

	def unbanChatMember(Map params = [:]) {
		api.go('unbanChatMember', [chat_id: lastUpdate.message.chat.id, user_id: lastUpdate.message.from.id] + params)
	}


	def unbanChatMember(def chatId, def userId, Map params = [:]) {
		api.go('unbanChatMember', [chat_id: chatId, user_id: userId] + params)
	}

	/* --- answerCallbackQuery ---*/

	def answerCallbackQuery(Map params = [:]) {
		api.go('answerCallbackQuery', [callback_query_id: lastUpdate.message.chat.id] + params)
	}

	def answerCallbackQuery(def callbackQueryId, Map params = [:]) {
		api.go('answerCallbackQuery', [callback_query_id: callbackQueryId] + params)
	}

	/* --- editMessageText ---*/

	def editMessageText(int messageId, String text, Map params = [:]) {
		api.go('editMessageText', [chat_id: lastUpdate.message.chat.id, message_id: messageId, text: text] + params)
	}

	def editMessageText(def chatId, int messageId, String text, Map params = [:]) {
		api.go('editMessageText', [chat_id: chatId, message_id: messageId, text: text] + params)
	}

	/* --- editMessageCaption ---*/

	def editMessageCaption(int messageId, String caption = '', Map params = [:]) {
		api.go('editMessageCaption', [chat_id: lastUpdate.message.chat.id, message_id: messageId, caption: caption] + params)
	}

	def editMessageCaption(def chatId, int messageId, String caption = '', Map params = [:]) {
		api.go('editMessageCaption', [chat_id: chatId, message_id: messageId, caption: caption] + params)
	}

	/* --- editMessageReplyMarkup ---*/

	def editMessageReplyMarkup(int messageId, Map params = [:]) {
		api.go('editMessageReplyMarkup', [chat_id: lastUpdate.message.chat.id, message_id: messageId, reply_markup: [:]] + params)
	}

	def editMessageReplyMarkup(def chatId, int messageId, Map replyMarkup, Map params = [:]) {
		api.go('editMessageReplyMarkup', [chat_id: chatId, message_id: messageId, reply_markup: replyMarkup] + params)
	}



	// small hack :)
	Api getApi() {
		return api
	}
}