package tech.teslex.telegroo.simple.methods

import groovy.transform.CompileStatic
import tech.teslex.telegroo.simple.methods.traits.*
import tech.teslex.telegroo.simple.methods.traits.games.GetGameHighScoresMethodTrait
import tech.teslex.telegroo.simple.methods.traits.games.SendGameMethodTrait
import tech.teslex.telegroo.simple.methods.traits.games.SetGameScoreMethodTrait
import tech.teslex.telegroo.simple.methods.traits.payments.AnswerPreCheckoutQueryMethodTrait
import tech.teslex.telegroo.simple.methods.traits.payments.AnswerShippingQueryMethodTrait
import tech.teslex.telegroo.simple.methods.traits.payments.SendInvoiceMethodTrait
import tech.teslex.telegroo.simple.methods.traits.webhook.DeleteWebhookMethodTrait
import tech.teslex.telegroo.simple.methods.traits.webhook.GetWebhookInfoMethodTrait
import tech.teslex.telegroo.simple.methods.traits.webhook.SetWebhookMethodTrait

@CompileStatic
trait MethodsTraits implements

		GetUpdatesMethodTrait,
		SetWebhookMethodTrait,
		DeleteWebhookMethodTrait,
		GetWebhookInfoMethodTrait,

		ReplyTrait,

		GetMeMethodTrait,
		SendMessageMethodTrait,
		ForwardMessageMethodTrait,
		SendPhotoMethodTrait,
		SendAudioMethodTrait,
		SendDocumentMethodTrait,
		SendVideoMethodTrait,
		SendAnimationMethodTrait,
		SendVoiceMethodTrait,
		SendVideoNoteMethodTrait,
		SendMediaGroupMethodTrait,
		SendLocationMethodTrait,
		EditMessageLiveLocationMethodTrait,
		StopMessageLiveLocationMethodTrait,
		SendVenueMethodTrait,
		SendContactMethodTrait,
		SendChatActionMethodTrait,
		GetUserProfilePhotosMethodTrait,
		GetFileMethodTrait,
		KickChatMemberMethodTrait,
		UnbanChatMemberMethodTrait,
		RestrictChatMemberMethodTrait,
		PromoteChatMemberMethodTrait,
		ExportChatInviteLinkMethodTrait,
		SetChatPhotoMethodTrait,
		DeleteChatPhotoMethodTrait,
		SetChatTitleMethodTrait,
		SetChatDescriptionMethodTrait,
		PinChatMessageMethodTrait,
		UnpinChatMessageMethodTrait,
		LeaveChatMethodTrait,
		GetChatMethodTrait,
		GetChatAdministratorsMethodTrait,
		GetChatMembersCountMethodTrait,
		GetChatMemberMethodTrait,
		SetChatStickerSetMethodTrait,
		DeleteChatStickerSetMethodTrait,
		AnswerCallbackQueryMethodTrait,

		EditMessageTextMethodTrait,
		EditMessageCaptionMethodTrait,
		EditMessageMediaMethodTrait,
		EditMessageReplyMarkupMethodTrait,
		DeleteMessageMethodTrait,

		SendStickerMethodTrait,
		GetStickerSetMethodTrait,
		CreateNewStickerSetMethodTrait,
		AddStickerToSetMethodTrait,
		SetStickerPositionInSetMethodTrait,
		DeleteStickerFromSetMethodTrait,
		UploadStickerFileMethodTrait,

		AnswerInlineQueryMethodTrait,

		SendInvoiceMethodTrait,
		AnswerShippingQueryMethodTrait,
		AnswerPreCheckoutQueryMethodTrait,

		SendGameMethodTrait,
		SetGameScoreMethodTrait,
		GetGameHighScoresMethodTrait {}