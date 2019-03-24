package tech.teslex.telegroo.telegram.methods.objects.payments

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.methods.MethodObjectAnnotations
import tech.teslex.telegroo.telegram.types.InlineKeyboardMarkup
import tech.teslex.telegroo.telegram.types.payments.LabeledPrice

/**
 * sendInvoice
 * Use this method to send invoices. On success, the sent Message is returned.
 */
@MethodObjectAnnotations
class SendInvoiceMethodObject implements MethodObject {

	/**
	 * Unique identifier for the target private chat
	 */
	@JsonProperty(value = 'chat_id', required = true)
	Integer chatId

	/**
	 * Product name, 1-32 characters
	 */
	@JsonProperty(required = true)
	String title

	/**
	 * Product description, 1-255 characters
	 */
	@JsonProperty(required = true)
	String description

	/**
	 * Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
	 */
	@JsonProperty(required = true)
	String payload

	/**
	 * Payments provider token, obtained via Botfather
	 */
	@JsonProperty(value = 'provider_token', required = true)
	String providerToken

	/**
	 * Unique deep-linking parameter that can be used to generate this invoice when used as a start parameter
	 */
	@JsonProperty(value = 'start_parameter', required = true)
	String startParameter

	/**
	 * Three-letter ISO 4217 currency code, see more on currencies
	 */
	@JsonProperty(required = true)
	String currency

	/**
	 * Price breakdown, a list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.)
	 */
	@JsonProperty(required = true)
	List<LabeledPrice> prices

	/**
	 * JSON-encoded data about the invoice, which will be shared with the payment provider. A detailed description of required fields should be provided by the payment provider.
	 */
	@JsonProperty(value = 'provider_data', required = false)
	String providerData

	/**
	 * URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service. People like it better when they see what they are paying for.
	 */
	@JsonProperty(value = 'photo_url', required = false)
	String photoUrl

	/**
	 * Photo size
	 */
	@JsonProperty(value = 'photo_size', required = false)
	Integer photoSize

	/**
	 * Photo width
	 */
	@JsonProperty(value = 'photo_width', required = false)
	Integer photoWidth

	/**
	 * Photo height
	 */
	@JsonProperty(value = 'photo_height', required = false)
	Integer photoHeight

	/**
	 * Pass True, if you require the user's full name to complete the order
	 */
	@JsonProperty(value = 'need_name', required = false)
	Boolean needName

	/**
	 * Pass True, if you require the user's phone number to complete the order
	 */
	@JsonProperty(value = 'need_phone_number', required = false)
	Boolean needPhoneNumber

	/**
	 * Pass True, if you require the user's email address to complete the order
	 */
	@JsonProperty(value = 'need_email', required = false)
	Boolean needEmail

	/**
	 * Pass True, if you require the user's shipping address to complete the order
	 */
	@JsonProperty(value = 'need_shipping_address', required = false)
	Boolean needShippingAddress

	/**
	 * Pass True, if user's phone number should be sent to provider
	 */
	@JsonProperty(value = 'send_phone_number_to_provider', required = false)
	Boolean sendPhoneNumberToProvider

	/**
	 * Pass True, if user's email address should be sent to provider
	 */
	@JsonProperty(value = 'send_email_to_provider', required = false)
	Boolean sendEmailToProvider

	/**
	 * Pass True, if the final price depends on the shipping method
	 */
	@JsonProperty(value = 'is_flexible', required = false)
	Boolean isFlexible

	/**
	 * Sends the message silently. Users will receive a notification with no sound.
	 */
	@JsonProperty(value = 'disable_notification', required = false)
	Boolean disableNotification

	/**
	 * If the message is a reply, ID of the original message
	 */
	@JsonProperty(value = 'reply_to_message_id', required = false)
	Integer replyToMessageId

	/**
	 * A JSON-serialized object for an inline keyboard. If empty, one 'Pay total price' button will be shown. If not empty, the first button must be a Pay button.
	 */
	@JsonProperty(value = 'reply_markup', required = false)
	InlineKeyboardMarkup replyMarkup

	@Override
	@JsonIgnore
	String getPathMethod() {
		'sendInvoice'
	}
}
