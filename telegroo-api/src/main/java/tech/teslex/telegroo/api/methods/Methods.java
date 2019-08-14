package tech.teslex.telegroo.api.methods;

import tech.teslex.telegroo.api.methods.games.DefaultGetGameHighScoresMethod;
import tech.teslex.telegroo.api.methods.games.DefaultSendGameMethod;
import tech.teslex.telegroo.api.methods.games.DefaultSetGameScoreMethod;
import tech.teslex.telegroo.api.methods.payments.DefaultAnswerPreCheckoutQueryMethod;
import tech.teslex.telegroo.api.methods.payments.DefaultAnswerShippingQueryMethod;
import tech.teslex.telegroo.api.methods.payments.DefaultSendInvoiceMethod;
import tech.teslex.telegroo.api.methods.polls.DefaultSendPollMethod;
import tech.teslex.telegroo.api.methods.polls.DefaultStopPollMethod;
import tech.teslex.telegroo.api.methods.webhook.DefaultGetWebhookInfoMethod;

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

		DefaultStopMessageLiveLocationMethod {
}