package tech.teslex.telegroo.telegram.api.methods.objects.payments;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup;
import tech.teslex.telegroo.telegram.api.types.payments.LabeledPrice;

import java.util.List;

/**
 * sendInvoice
 * Use this method to send invoices. On success, the sent Message is returned.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendInvoice implements MethodObject {

	/**
	 * Unique identifier for the target private chat
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Integer chatId;
	/**
	 * Product name, 1-32 characters
	 */
	@JsonProperty(required = true)
	private String title;
	/**
	 * Product description, 1-255 characters
	 */
	@JsonProperty(required = true)
	private String description;
	/**
	 * Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
	 */
	@JsonProperty(required = true)
	private String payload;
	/**
	 * Payments provider token, obtained via Botfather
	 */
	@JsonProperty(value = "provider_token", required = true)
	private String providerToken;
	/**
	 * Unique deep-linking parameter that can be used to generate this invoice when used as a start parameter
	 */
	@JsonProperty(value = "start_parameter", required = true)
	private String startParameter;
	/**
	 * Three-letter ISO 4217 currency code, see more on currencies
	 */
	@JsonProperty(required = true)
	private String currency;
	/**
	 * Price breakdown, a list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.)
	 */
	@JsonProperty(required = true)
	private List<LabeledPrice> prices;
	/**
	 * JSON-encoded data about the invoice, which will be shared with the payment provider. A detailed description of required fields should be provided by the payment provider.
	 */
	@JsonProperty(value = "provider_data", required = false)
	private String providerData;
	/**
	 * URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service. People like it better when they see what they are paying for.
	 */
	@JsonProperty(value = "photo_url", required = false)
	private String photoUrl;
	/**
	 * Photo size
	 */
	@JsonProperty(value = "photo_size", required = false)
	private Integer photoSize;
	/**
	 * Photo width
	 */
	@JsonProperty(value = "photo_width", required = false)
	private Integer photoWidth;
	/**
	 * Photo height
	 */
	@JsonProperty(value = "photo_height", required = false)
	private Integer photoHeight;
	/**
	 * Pass True, if you require the user's full name to complete the order
	 */
	@JsonProperty(value = "need_name", required = false)
	private Boolean needName;
	/**
	 * Pass True, if you require the user's phone number to complete the order
	 */
	@JsonProperty(value = "need_phone_number", required = false)
	private Boolean needPhoneNumber;
	/**
	 * Pass True, if you require the user's email address to complete the order
	 */
	@JsonProperty(value = "need_email", required = false)
	private Boolean needEmail;
	/**
	 * Pass True, if you require the user's shipping address to complete the order
	 */
	@JsonProperty(value = "need_shipping_address", required = false)
	private Boolean needShippingAddress;
	/**
	 * Pass True, if user's phone number should be sent to provider
	 */
	@JsonProperty(value = "send_phone_number_to_provider", required = false)
	private Boolean sendPhoneNumberToProvider;
	/**
	 * Pass True, if user's email address should be sent to provider
	 */
	@JsonProperty(value = "send_email_to_provider", required = false)
	private Boolean sendEmailToProvider;
	/**
	 * Pass True, if the final price depends on the shipping method
	 */
	@JsonProperty(value = "is_flexible", required = false)
	private Boolean isFlexible;
	/**
	 * Sends the message silently. Users will receive a notification with no sound.
	 */
	@JsonProperty(value = "disable_notification", required = false)
	private Boolean disableNotification;
	/**
	 * If the message is a reply, ID of the original message
	 */
	@JsonProperty(value = "reply_to_message_id", required = false)
	private Integer replyToMessageId;
	/**
	 * A JSON-serialized object for an inline keyboard. If empty, one 'Pay total price' button will be shown. If not empty, the first button must be a Pay button.
	 */
	@JsonProperty(value = "reply_markup", required = false)
	private InlineKeyboardMarkup replyMarkup;

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "sendInvoice";
	}
}