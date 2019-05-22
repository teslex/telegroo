/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * © 2019 TesLex
 */

package tech.teslex.telegroo.api.context;

import tech.teslex.telegroo.api.TelegramClient;
import tech.teslex.telegroo.api.methods.reply.ReplyMethod;
import tech.teslex.telegroo.api.methods.reply.WithMethodObject;
import tech.teslex.telegroo.telegram.TelegramResult;
import tech.teslex.telegroo.telegram.methods.interfaces.*;
import tech.teslex.telegroo.telegram.methods.interfaces.games.GetGameHighScoresMethod;
import tech.teslex.telegroo.telegram.methods.interfaces.games.SendGameMethod;
import tech.teslex.telegroo.telegram.methods.interfaces.games.SetGameScoreMethod;
import tech.teslex.telegroo.telegram.methods.interfaces.payments.AnswerPreCheckoutQueryMethod;
import tech.teslex.telegroo.telegram.methods.interfaces.payments.AnswerShippingQueryMethod;
import tech.teslex.telegroo.telegram.methods.interfaces.payments.SendInvoiceMethod;
import tech.teslex.telegroo.telegram.methods.interfaces.polls.SendPollMethod;
import tech.teslex.telegroo.telegram.methods.interfaces.polls.StopPollMethod;
import tech.teslex.telegroo.telegram.methods.interfaces.webhook.DeleteWebhookMethod;
import tech.teslex.telegroo.telegram.methods.interfaces.webhook.GetWebhookInfoMethod;
import tech.teslex.telegroo.telegram.methods.interfaces.webhook.SetWebhookMethod;
import tech.teslex.telegroo.telegram.types.*;
import tech.teslex.telegroo.telegram.types.games.GameHighScore;
import tech.teslex.telegroo.telegram.types.stickers.StickerSet;
import tech.teslex.telegroo.telegram.types.update.Update;

import java.util.List;

/**
 * MethodsContext
 *
 * @param <TC>
 */
public interface MethodsContext<TC extends TelegramClient> extends Context<TC>,

		GetUpdatesMethod<TelegramResult<List<Update>>>,

		SetWebhookMethod<TelegramResult<Object>>,
		DeleteWebhookMethod<TelegramResult<Object>>,
		GetWebhookInfoMethod<TelegramResult<WebhookInfo>>,

		ReplyMethod,
		WithMethodObject,

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
		SendMediaGroupMethod<TelegramResult<List<Message>>>,
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
		GetGameHighScoresMethod<TelegramResult<List<GameHighScore>>>,

		SendPollMethod<TelegramResult<Message>>,
		StopPollMethod<TelegramResult<Poll>> {
}