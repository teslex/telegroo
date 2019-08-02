package tech.teslex.telegroo.telegram.api.types.payments;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.types.User;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PreCheckoutQuery {

	/**
	 * Unique query identifier
	 */
	private String id;
	/**
	 * User who sent the query
	 */
	private User from;
	/**
	 * Three-letter ISO 4217 currency code
	 */
	private String currency;
	/**
	 * Total price in the smallest units of the currency (integer, not float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
	 */
	@JsonProperty(value = "total_amount")
	private Integer totalAmount;
	/**
	 * Bot specified invoice payload
	 */
	@JsonProperty(value = "invoice_payload")
	private String invoicePayload;
	/**
	 * Optional. Identifier of the shipping option chosen by the user
	 */
	@JsonProperty(value = "shipping_option_id", required = false)
	private String shippingOptionId;
	/**
	 * Optional. Order info provided by the user
	 */
	@JsonProperty(value = "order_info", required = false)
	private OrderInfo orderInfo;
}
