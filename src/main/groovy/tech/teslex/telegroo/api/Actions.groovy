package tech.teslex.telegroo.api

import tech.teslex.telegroo.api.actions.*

trait Actions implements
		GetUpdates,
		Reply,
		Forward,
		SendMessage,
		SendPhoto,
		SendVideo,
		SendAudio,
		SendDocument,
		SendSticker,
		SendVenue,
		SendVoice,
		SendLocation,
		SendContact,
		SendChatAction,
		GetFile,
		GetUserProfilePhotos,
		KickChatMemeber,
		UnbanChatMember,
		EditMessageCaption,
		EditMessageText,
		EditMessageReplyMarkup,
		AnswerCallbackQuery,
		SendMediaGroup {

	def getMe() {
		api.go('getMe')
	}
}