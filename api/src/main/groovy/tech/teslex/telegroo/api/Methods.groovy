package tech.teslex.telegroo.api

import tech.teslex.telegroo.api.methods.*

trait Methods
		implements
				GetMe,
				GetUpdates,
				GetFile,
				GetUserProfilePhotos,

				SendMessage,
				SendPhoto,
				SendVideo,
				SendVideoNote,
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
				DeleteMessage,

				GetChatMember,
				GetChatMembersCount,
				GetChatAdministrators,
				GetChat,
				LeaveChat,
				SetChatStickerSet,
				DeleteChatStickerSet,
				PinChatMessage,
				UnpinChatMessage,
				PromoteChatMember,
				RestrictChatMember,
				SetChatDescription,
				SetChatPhoto,
				SetChatTitle,
				DeleteChatPhoto,
				KickChatMember,
				UnbanChatMember,
				ExportChatInviteLink,

				SetWebhook,
				DeleteWebhook,
				GetWebhookInfo,

				SendInvoice,

				AnswerCallbackQuery,
				EditMessageLiveLocation,
				StopMessageLiveLocation {
}