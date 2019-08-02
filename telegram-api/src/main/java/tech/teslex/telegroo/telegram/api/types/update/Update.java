package tech.teslex.telegroo.telegram.api.types.update;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.types.CallbackQuery;
import tech.teslex.telegroo.telegram.api.types.Message;
import tech.teslex.telegroo.telegram.api.types.Poll;
import tech.teslex.telegroo.telegram.api.types.inline.ChosenInlineResult;
import tech.teslex.telegroo.telegram.api.types.inline.InlineQuery;
import tech.teslex.telegroo.telegram.api.types.payments.PreCheckoutQuery;
import tech.teslex.telegroo.telegram.api.types.payments.ShippingQuery;
import tech.teslex.telegroo.telegram.enums.UpdateType;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Update {

	/**
	 * The update‘s unique identifier. Update identifiers start from a certain positive number and increase sequentially. This ID becomes especially handy if you’re using Webhooks, since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order. If there are no new updates for at least a week, then identifier of the next update will be chosen randomly instead of sequentially.
	 */
	@JsonProperty(value = "update_id")
	private Long updateId = 0L;
	/**
	 * Optional. New incoming message of any kind — text, photo, sticker, etc.
	 */
	@JsonProperty(required = false)
	private Message message;
	/**
	 * Optional. New version of a message that is known to the bot and was edited
	 */
	@JsonProperty(value = "edited_message", required = false)
	private Message editedMessage;
	/**
	 * Optional. New incoming channel post of any kind — text, photo, sticker, etc.
	 */
	@JsonProperty(value = "channel_post", required = false)
	private Message channelPost;
	/**
	 * Optional. New version of a channel post that is known to the bot and was edited
	 */
	@JsonProperty(value = "edited_channel_post", required = false)
	private Message editedChannelPost;
	/**
	 * Optional. New incoming shipping query. Only for invoices with flexible price
	 */
	@JsonProperty(value = "shipping_query", required = false)
	private ShippingQuery shippingQuery;
	/**
	 * Optional. New incoming pre-checkout query. Contains full information about checkout
	 */
	@JsonProperty(value = "pre_checkout_query", required = false)
	private PreCheckoutQuery preCheckoutQuery;
	/**
	 * Optional. New incoming callback query
	 */
	@JsonProperty(value = "callback_query", required = false)
	private CallbackQuery callbackQuery;
	/**
	 * Optional. New incoming inline query
	 */
	@JsonProperty(value = "inline_query", required = false)
	private InlineQuery inlineQuery;
	/**
	 * Optional. The result of an inline query that was chosen by a user and sent to their chat partner. Please see our documentation on the feedback collecting for details on how to enable these updates for your bot.
	 */
	@JsonProperty(value = "chosen_inline_result", required = false)
	private ChosenInlineResult chosenInlineResult;
	/**
	 * Optional. New poll state. Bots receive only updates about polls, which are sent or stopped by the bot
	 */
	@JsonProperty(required = false)
	private Poll poll;

	/**
	 * Not a Telegram API part. Just an utility.
	 *
	 * Returns update type;
	 *
	 * @see UpdateType
	 *
	 * @return update type
	 */
	@JsonIgnore
	public UpdateType getUpdateType() {
		if (message != null) return UpdateType.MESSAGE;
		else if (editedMessage != null) return UpdateType.EDITED_MESSAGE;
		else if (channelPost != null) return UpdateType.CHANNEL_POST;
		else if (editedChannelPost != null) return UpdateType.EDITED_CHANNEL_POST;
		else if (shippingQuery != null) return UpdateType.SHIPPING_QUERY;
		else if (preCheckoutQuery != null) return UpdateType.PRE_CHECKOUT_QUERY;
		else if (callbackQuery != null) return UpdateType.CALLBACK_QUERY;
		else if (inlineQuery != null) return UpdateType.INLINE_QUERY;
		else if (chosenInlineResult != null) return UpdateType.CHOSEN_INLINE_QUERY;
		else if (poll != null) return UpdateType.POLL;
		else return UpdateType.UPDATE;
	}

	/**
	 * Not a Telegram API part. Just an utility.
	 *
	 * Returns chat id if specified.
	 *
	 * @return id of the chat
	 */
	@JsonIgnore
	public Long getChatId() {
		if (message != null) return message.getChat().getId();
		else if (editedMessage != null) return editedMessage.getChat().getId();
		else if (channelPost != null) return channelPost.getChat().getId();
		else if (editedChannelPost != null) return editedChannelPost.getChat().getId();
		else return -1L;
	}
}
