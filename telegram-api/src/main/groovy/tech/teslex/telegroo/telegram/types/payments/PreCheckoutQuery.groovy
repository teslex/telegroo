package tech.teslex.telegroo.telegram.types.payments

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.ToString
import tech.teslex.telegroo.telegram.types.User

@ToString
@CompileStatic
class PreCheckoutQuery {

	/**
	 * Unique query identifier
	 */
	String id

	/**
	 * User who sent the query
	 */
	User from

	/**
	 * Three-letter ISO 4217 currency code
	 */
	String currency

	/**
	 * Total price in the smallest units of the currency (integer, not float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
	 */
	@JsonProperty(value = 'total_amount')
	Integer totalAmount

	/**
	 * Bot specified invoice payload
	 */
	@JsonProperty(value = 'invoice_payload')
	String invoicePayload

	/**
	 * Optional. Identifier of the shipping option chosen by the user
	 */
	@JsonProperty(value = 'shipping_option_id', required = false)
	String shippingOptionId

	/**
	 * Optional. Order info provided by the user
	 */
	@JsonProperty(value = 'order_info', required = false)
	OrderInfo orderInfo
}
