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
		SendMediaGroup,
		SetWebhook,
		DeleteWebhook,
		GetWebhookInfo {

	def getMe() {
		if (!me)
			me = api.go('getMe')
		me
	}

	def getMeMe() {
		api.go('getMe')
	}
}