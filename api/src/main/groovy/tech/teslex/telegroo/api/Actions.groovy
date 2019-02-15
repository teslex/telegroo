package tech.teslex.telegroo.api

import tech.teslex.telegroo.api.actions.*

trait Actions
		implements
				GetMe,
				GetUpdates,
				GetFile,
				GetUserProfilePhotos,

				SendMessage,
				SendPhoto,
				SendVideo,
				SendAudio,
				SendDocument,
				SendMediaGroup,
				SendSticker,
				SendVenue,
				SendVoice,
				SendLocation,
				SendContact,
				SendChatAction,
				EditMessageCaption,
				EditMessageText,
				EditMessageReplyMarkup,

				Reply,
				Forward,

				KickChatMemeber,
				UnbanChatMember,

				SetWebhook,
				DeleteWebhook,
				GetWebhookInfo,

				AnswerCallbackQuery {

}