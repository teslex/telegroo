package tech.teslex.telegroo.telegram.types.update

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.ToString
import tech.teslex.telegroo.telegram.enums.UpdateType
import tech.teslex.telegroo.telegram.types.CallbackQuery
import tech.teslex.telegroo.telegram.types.Message
import tech.teslex.telegroo.telegram.types.payments.PreCheckoutQuery
import tech.teslex.telegroo.telegram.types.payments.ShippingQuery

@ToString
@CompileStatic
class Update {

	/**
	 * The update‘s unique identifier. Update identifiers start from a certain positive number and increase sequentially. This ID becomes especially handy if you’re using Webhooks, since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order. If there are no new updates for at least a week, then identifier of the next update will be chosen randomly instead of sequentially.
	 */
	@JsonProperty(value = 'update_id')
	Integer updateId


	/**
	 * Optional. New incoming message of any kind — text, photo, sticker, etc.
	 */
	@JsonProperty(required = false)
	Message message

	/**
	 * Optional. New version of a message that is known to the bot and was edited
	 */
	@JsonProperty(value = 'edited_message', required = false)
	Message editedMessage

	/**
	 * Optional. New incoming channel post of any kind — text, photo, sticker, etc.
	 */
	@JsonProperty(value = 'channel_post', required = false)
	Message channelPost

	/**
	 * Optional. New version of a channel post that is known to the bot and was edited
	 */
	@JsonProperty(value = 'edited_channel_post', required = false)
	Message editedChannelPost

	/**
	 * Optional. New incoming shipping query. Only for invoices with flexible price
	 */
	@JsonProperty(value = 'shipping_query', required = false)
	ShippingQuery shippingQuery

	/**
	 * Optional. New incoming pre-checkout query. Contains full information about checkout
	 */
	@JsonProperty(value = 'pre_checkout_query', required = false)
	PreCheckoutQuery preCheckoutQuery

	/**
	 * Optional. New incoming callback query
	 */
	@JsonProperty(value = 'callback_query', required = false)
	CallbackQuery callbackQuery


	// todo: implement
///**
// * Optional. New incoming inline query
// */
//	@JsonProperty(value = 'inline_query', required = false)
//	InlineQuery inlineQuery

///**
// * Optional. The result of an inline query that was chosen by a user and sent to their chat partner. Please see our documentation on the feedback collecting for details on how to enable these updates for your bot.
// */
//	@JsonProperty(value = 'chosen_inline_result', required = false)
//	ChosenInlineResult chosenInlineResult


	@JsonIgnore
	UpdateType getUpdateType() {
		// fuck ;(
		if (message != null)
			UpdateType.MESSAGE
		else if (editedMessage != null)
			UpdateType.EDITED_MESSAGE
		else if (channelPost != null)
			UpdateType.CHANNEL_POST
		else if (editedChannelPost != null)
			UpdateType.EDITED_CHANNEL_POST
		else if (shippingQuery != null)
			UpdateType.SHIPPING_QUERY
		else if (preCheckoutQuery != null)
			UpdateType.PRE_CHECKOUT_QUERY
		else if (callbackQuery != null)
			UpdateType.CALLBACK_QUERY
		else
			UpdateType.UPDATE
	}
}
