package tech.teslex.telegroo.api.methods.defaults;

import tech.teslex.telegroo.api.methods.defaults.games.DefaultGetGameHighScoresMethod;
import tech.teslex.telegroo.api.methods.defaults.games.DefaultSendGameMethod;
import tech.teslex.telegroo.api.methods.defaults.games.DefaultSetGameScoreMethod;
import tech.teslex.telegroo.api.methods.defaults.payments.DefaultAnswerPreCheckoutQueryMethod;
import tech.teslex.telegroo.api.methods.defaults.payments.DefaultAnswerShippingQueryMethod;
import tech.teslex.telegroo.api.methods.defaults.payments.DefaultSendInvoiceMethod;
import tech.teslex.telegroo.api.methods.defaults.polls.DefaultSendPollMethod;
import tech.teslex.telegroo.api.methods.defaults.polls.DefaultStopPollMethod;
import tech.teslex.telegroo.api.methods.defaults.webhook.DefaultGetWebhookInfoMethod;

public interface Methods extends

		DefaultGetGameHighScoresMethod,
		DefaultSendGameMethod,
		DefaultSetGameScoreMethod,

		DefaultAnswerPreCheckoutQueryMethod,
		DefaultAnswerShippingQueryMethod,
		DefaultSendInvoiceMethod,

		DefaultSendPollMethod,
		DefaultStopPollMethod,

		DefaultDeleteWebhookMethod,
		DefaultGetWebhookInfoMethod,
		DefaultSetWebhookMethod,

		DefaultAddStickerToSetMethod,
		DefaultCreateNewStickerSetMethod,
		DefaultGetStickerSetMethod,
		DefaultUploadStickerFileMethod,

		DefaultAnswerCallbackQueryMethod,
		DefaultAnswerInlineQueryMethod,

		DefaultDeleteChatPhotoMethod,
		DefaultDeleteChatStickerSetMethod,
		DefaultDeleteMessageMethod,
		DefaultDeleteStickerFromSetMethod,

		DefaultEditMessageCaptionMethod,
		DefaultEditMessageLiveLocationMethod,
		DefaultEditMessageMediaMethod,
		DefaultEditMessageReplyMarkupMethod,
		DefaultEditMessageTextMethod,

		DefaultExportChatInviteLinkMethod,

		DefaultForwardMessageMethod,

		DefaultGetChatAdministratorsMethod,
		DefaultGetChatMemberMethod,
		DefaultGetChatMembersCountMethod,
		DefaultGetChatMethod,

		DefaultGetFileMethod,

		DefaultGetMeMethod,

		DefaultGetUpdatesMethod,

		DefaultGetUserProfilePhotosMethod,

		DefaultKickChatMemberMethod,
		DefaultLeaveChatMethod,
		DefaultPinChatMessageMethod,
		DefaultPromoteChatMemberMethod,
		DefaultRestrictChatMemberMethod,
		DefaultUnbanChatMemberMethod,
		DefaultUnpinChatMessageMethod,

		DefaultSendAnimationMethod,
		DefaultSendAudioMethod,
		DefaultSendChatActionMethod,
		DefaultSendContactMethod,
		DefaultSendDocumentMethod,
		DefaultSendLocationMethod,
		DefaultSendMediaGroupMethod,
		DefaultSendMessageMethod,
		DefaultSendPhotoMethod,
		DefaultSendStickerMethod,
		DefaultSendVenueMethod,
		DefaultSendVideoMethod,
		DefaultSendVideoNoteMethod,
		DefaultSendVoiceMethod,

		DefaultSetChatDescriptionMethod,
		DefaultSetChatPhotoMethod,
		DefaultSetChatStickerSetMethod,
		DefaultSetChatTitleMethod,
		DefaultSetStickerPositionInSetMethod,

		DefaultStopMessageLiveLocationMethod, DefaultGetGameHighScoresMethod, DefaultSendGameMethod, DefaultSetGameScoreMethod, DefaultAnswerPreCheckoutQueryMethod, DefaultAnswerShippingQueryMethod, DefaultSendInvoiceMethod, DefaultSendPollMethod, DefaultStopPollMethod, DefaultDeleteWebhookMethod, DefaultGetWebhookInfoMethod, DefaultSetWebhookMethod, DefaultAddStickerToSetMethod, DefaultCreateNewStickerSetMethod, DefaultGetStickerSetMethod, DefaultUploadStickerFileMethod, DefaultAnswerCallbackQueryMethod, DefaultAnswerInlineQueryMethod, DefaultDeleteChatPhotoMethod, DefaultDeleteChatStickerSetMethod, DefaultDeleteMessageMethod, DefaultDeleteStickerFromSetMethod, DefaultEditMessageCaptionMethod, DefaultEditMessageLiveLocationMethod, DefaultEditMessageMediaMethod, DefaultEditMessageReplyMarkupMethod, DefaultEditMessageTextMethod, DefaultExportChatInviteLinkMethod, DefaultForwardMessageMethod, DefaultGetChatAdministratorsMethod, DefaultGetChatMemberMethod, DefaultGetChatMembersCountMethod, DefaultGetChatMethod, DefaultGetFileMethod, DefaultGetMeMethod, DefaultGetUpdatesMethod, DefaultGetUserProfilePhotosMethod, DefaultKickChatMemberMethod, DefaultLeaveChatMethod, DefaultPinChatMessageMethod, DefaultPromoteChatMemberMethod, DefaultRestrictChatMemberMethod, DefaultUnbanChatMemberMethod, DefaultUnpinChatMessageMethod, DefaultSendAnimationMethod, DefaultSendAudioMethod, DefaultSendChatActionMethod, DefaultSendContactMethod, DefaultSendDocumentMethod, DefaultSendLocationMethod, DefaultSendMediaGroupMethod, DefaultSendMessageMethod, DefaultSendPhotoMethod, DefaultSendStickerMethod, DefaultSendVenueMethod, DefaultSendVideoMethod, DefaultSendVideoNoteMethod, DefaultSendVoiceMethod, DefaultSetChatDescriptionMethod, DefaultSetChatPhotoMethod, DefaultSetChatStickerSetMethod, DefaultSetChatTitleMethod, DefaultSetStickerPositionInSetMethod, DefaultStopMessageLiveLocationMethod {
}