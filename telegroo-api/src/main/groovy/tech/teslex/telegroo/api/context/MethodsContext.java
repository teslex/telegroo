package tech.teslex.telegroo.api.context;

import tech.teslex.telegroo.api.methods.reply.ReplyMethod;
import tech.teslex.telegroo.telegram.TelegramResult;
import tech.teslex.telegroo.telegram.methods.interfaces.*;
import tech.teslex.telegroo.telegram.methods.interfaces.games.GetGameHighScoresMethod;
import tech.teslex.telegroo.telegram.methods.interfaces.games.SendGameMethod;
import tech.teslex.telegroo.telegram.methods.interfaces.games.SetGameScoreMethod;
import tech.teslex.telegroo.telegram.methods.interfaces.payments.AnswerPreCheckoutQueryMethod;
import tech.teslex.telegroo.telegram.methods.interfaces.payments.AnswerShippingQueryMethod;
import tech.teslex.telegroo.telegram.methods.interfaces.payments.SendInvoiceMethod;
import tech.teslex.telegroo.telegram.methods.interfaces.webhook.DeleteWebhookMethod;
import tech.teslex.telegroo.telegram.methods.interfaces.webhook.GetWebhookInfoMethod;
import tech.teslex.telegroo.telegram.methods.interfaces.webhook.SetWebhookMethod;
import tech.teslex.telegroo.telegram.types.*;
import tech.teslex.telegroo.telegram.types.games.GameHighScore;
import tech.teslex.telegroo.telegram.types.stickers.StickerSet;
import tech.teslex.telegroo.telegram.types.update.Update;

import java.util.List;

public interface MethodsContext<T> extends Context<T>,

		GetUpdatesMethod<TelegramResult<List<Update>>>,

		SetWebhookMethod<TelegramResult<Object>>,
		DeleteWebhookMethod<TelegramResult<Object>>,
		GetWebhookInfoMethod<TelegramResult<WebhookInfo>>,

		ReplyMethod,

		GetMeMethod<TelegramResult<User>>,

		SendMessageMethod<TelegramResult<Message>>,
		ForwardMessageMethod<TelegramResult<Message>>,

		SendPhotoMethod<TelegramResult<Message>>,
		SendAudioMethod<TelegramResult<Message>>,
		SendDocumentMethod<TelegramResult<Message>>,
		SendVideoMethod<TelegramResult<Message>>,
		SendAnimationMethod<TelegramResult<Message>>,
		SendVoiceMethod<TelegramResult<Message>>,
		SendVideoNoteMethod<TelegramResult<Message>>,
		SendMediaGroupMethod<TelegramResult<Message>>,
		SendLocationMethod<TelegramResult<Message>>,
		SendVenueMethod<TelegramResult<Object>>,
		SendContactMethod<TelegramResult<Message>>,

		SendChatActionMethod<TelegramResult<Object>>,
		GetUserProfilePhotosMethod<TelegramResult<UserProfilePhotos>>,
		GetFileMethod<TelegramResult<FileObject>>,

		KickChatMemberMethod<TelegramResult<Object>>,
		UnbanChatMemberMethod<TelegramResult<Object>>,
		RestrictChatMemberMethod<TelegramResult<Object>>,
		PromoteChatMemberMethod<TelegramResult<Object>>,
		ExportChatInviteLinkMethod<TelegramResult<String>>,
		SetChatPhotoMethod<TelegramResult<Object>>,
		DeleteChatPhotoMethod<TelegramResult<Object>>,
		SetChatTitleMethod<TelegramResult<Object>>,
		SetChatDescriptionMethod<TelegramResult<Object>>,
		PinChatMessageMethod<TelegramResult<Object>>,
		UnpinChatMessageMethod<TelegramResult<Object>>,
		LeaveChatMethod<TelegramResult<Object>>,
		GetChatMethod<TelegramResult<Chat>>,
		GetChatAdministratorsMethod<TelegramResult<List<ChatMember>>>,
		GetChatMembersCountMethod<TelegramResult<Integer>>,
		GetChatMemberMethod<TelegramResult<ChatMember>>,
		SetChatStickerSetMethod<TelegramResult<Object>>,
		DeleteChatStickerSetMethod<TelegramResult<Object>>,

		EditMessageTextMethod<TelegramResult<Object>>, // True or Message
		EditMessageCaptionMethod<TelegramResult<Object>>, // True or Message
		EditMessageMediaMethod<TelegramResult<Message>>, // True or Message
		EditMessageReplyMarkupMethod<TelegramResult<Message>>, // True or Message
		DeleteMessageMethod<TelegramResult<Object>>,

		EditMessageLiveLocationMethod<TelegramResult<Object>>, // True or Message
		StopMessageLiveLocationMethod<TelegramResult<Object>>, // True or Message

		SendStickerMethod<TelegramResult<Message>>,
		GetStickerSetMethod<TelegramResult<StickerSet>>,
		CreateNewStickerSetMethod<TelegramResult<Object>>,
		AddStickerToSetMethod<TelegramResult<Object>>,
		SetStickerPositionInSetMethod<TelegramResult<Object>>,
		DeleteStickerFromSetMethod<TelegramResult<Object>>,
		UploadStickerFileMethod<TelegramResult<FileObject>>,

		AnswerCallbackQueryMethod<TelegramResult<Object>>,
		AnswerInlineQueryMethod<TelegramResult<Object>>,

		SendInvoiceMethod<TelegramResult<Message>>,
		AnswerShippingQueryMethod<TelegramResult<Object>>,
		AnswerPreCheckoutQueryMethod<TelegramResult<Object>>,

		SendGameMethod<TelegramResult<Object>>, // True or Message
		SetGameScoreMethod<TelegramResult<Object>>, // True or Message
		GetGameHighScoresMethod<TelegramResult<List<GameHighScore>>> {
}