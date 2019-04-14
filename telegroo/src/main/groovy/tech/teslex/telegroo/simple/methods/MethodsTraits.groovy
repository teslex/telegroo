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

package tech.teslex.telegroo.simple.methods

import groovy.transform.CompileStatic
import tech.teslex.telegroo.simple.methods.traits.*
import tech.teslex.telegroo.simple.methods.traits.games.GetGameHighScoresMethodTrait
import tech.teslex.telegroo.simple.methods.traits.games.SendGameMethodTrait
import tech.teslex.telegroo.simple.methods.traits.games.SetGameScoreMethodTrait
import tech.teslex.telegroo.simple.methods.traits.payments.AnswerPreCheckoutQueryMethodTrait
import tech.teslex.telegroo.simple.methods.traits.payments.AnswerShippingQueryMethodTrait
import tech.teslex.telegroo.simple.methods.traits.payments.SendInvoiceMethodTrait
import tech.teslex.telegroo.simple.methods.traits.polls.SendPollMethodTrait
import tech.teslex.telegroo.simple.methods.traits.polls.StopPollMethodTrait
import tech.teslex.telegroo.simple.methods.traits.webhook.DeleteWebhookMethodTrait
import tech.teslex.telegroo.simple.methods.traits.webhook.GetWebhookInfoMethodTrait
import tech.teslex.telegroo.simple.methods.traits.webhook.SetWebhookMethodTrait

/**
 * This trait collects all methods traits to single trait
 */
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
		GetGameHighScoresMethodTrait,

		SendPollMethodTrait,
		StopPollMethodTrait {}