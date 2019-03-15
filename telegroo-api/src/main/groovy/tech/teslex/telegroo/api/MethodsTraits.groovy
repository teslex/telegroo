package tech.teslex.telegroo.api

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.traits.*
import tech.teslex.telegroo.api.traits.payments.AnswerPreCheckoutQueryMethodTrait
import tech.teslex.telegroo.api.traits.payments.AnswerShippingQueryMethodTrait
import tech.teslex.telegroo.api.traits.payments.SendInvoiceMethodTrait

@CompileStatic
trait MethodsTraits implements

		GetUpdatesMethodTrait,

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
		EditMessageMediaMethodTrait,
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

		AnswerInlineQueryMethodTrait,

		SendInvoiceMethodTrait,
		AnswerShippingQueryMethodTrait,
		AnswerPreCheckoutQueryMethodTrait {}
