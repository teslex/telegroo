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

package tech.teslex.telegroo.api.methods;

import groovy.lang.Newify;
import groovy.transform.AnnotationCollector;
import tech.teslex.telegroo.telegram.methods.objects.*;
import tech.teslex.telegroo.telegram.methods.objects.games.GetGameHighScoresMethodObject;
import tech.teslex.telegroo.telegram.methods.objects.games.SendGameMethodObject;
import tech.teslex.telegroo.telegram.methods.objects.games.SetGameScoreMethodObject;
import tech.teslex.telegroo.telegram.methods.objects.payments.AnswerPreCheckoutQueryMethodObject;
import tech.teslex.telegroo.telegram.methods.objects.payments.AnswerShippingQueryMethodObject;
import tech.teslex.telegroo.telegram.methods.objects.payments.SendInvoiceMethodObject;
import tech.teslex.telegroo.telegram.methods.objects.webhook.DeleteWebhookMethodObject;
import tech.teslex.telegroo.telegram.methods.objects.webhook.GetWebhookInfoMethodObject;
import tech.teslex.telegroo.telegram.methods.objects.webhook.SetWebhookMethodObject;

@Newify({
		GetUpdatesMethodObject.class,

		SetWebhookMethodObject.class,
		DeleteWebhookMethodObject.class,
		GetWebhookInfoMethodObject.class,

		SendMessageMethodObject.class,
		ForwardMessageMethodObject.class,

		SendPhotoMethodObject.class,
		SendAudioMethodObject.class,
		SendDocumentMethodObject.class,
		SendVideoMethodObject.class,
		SendAnimationMethodObject.class,
		SendVoiceMethodObject.class,
		SendVideoNoteMethodObject.class,
		SendMediaGroupMethodObject.class,
		SendLocationMethodObject.class,
		SendVenueMethodObject.class,
		SendContactMethodObject.class,

		SendChatActionMethodObject.class,
		GetUserProfilePhotosMethodObject.class,
		GetFileMethodObject.class,

		KickChatMemberMethodObject.class,
		UnbanChatMemberMethodObject.class,
		RestrictChatMemberMethodObject.class,
		PromoteChatMemberMethodObject.class,
		ExportChatInviteLinkMethodObject.class,
		SetChatPhotoMethodObject.class,
		DeleteChatPhotoMethodObject.class,
		SetChatTitleMethodObject.class,
		SetChatDescriptionMethodObject.class,
		PinChatMessageMethodObject.class,
		UnpinChatMessageMethodObject.class,
		LeaveChatMethodObject.class,
		GetChatMethodObject.class,
		GetChatAdministratorsMethodObject.class,
		GetChatMembersCountMethodObject.class,
		GetChatMemberMethodObject.class,
		SetChatStickerSetMethodObject.class,
		DeleteChatStickerSetMethodObject.class,

		EditMessageTextMethodObject.class,
		EditMessageCaptionMethodObject.class,
		EditMessageMediaMethodObject.class,
		EditMessageReplyMarkupMethodObject.class,
		DeleteMessageMethodObject.class,

		EditMessageLiveLocationMethodObject.class,
		StopMessageLiveLocationMethodObject.class,

		SendStickerMethodObject.class,
		GetStickerSetMethodObject.class,
		CreateNewStickerSetMethodObject.class,
		AddStickerToSetMethodObject.class,
		SetStickerPositionInSetMethodObject.class,
		DeleteStickerFromSetMethodObject.class,
		UploadStickerFileMethodObject.class,

		AnswerCallbackQueryMethodObject.class,
		AnswerInlineQueryMethodObject.class,

		SendInvoiceMethodObject.class,
		AnswerShippingQueryMethodObject.class,
		AnswerPreCheckoutQueryMethodObject.class,

		SendGameMethodObject.class,
		SetGameScoreMethodObject.class,
		GetGameHighScoresMethodObject.class
})
@AnnotationCollector
public @interface NewifyMethodsObjects {
}
