package tech.teslex.telegroo.telegram.types.payments


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.TypeAnnotations
import tech.teslex.telegroo.telegram.types.User

@TypeAnnotations
class ShippingQuery {

	/**
	 * Unique query identifier
	 */
	String id

	/**
	 * User who sent the query
	 */
	User from

	/**
	 * Bot specified invoice payload
	 */
	@JsonProperty(value = 'invoice_payload')
	String invoicePayload

	/**
	 * User specified shipping address
	 */
	@JsonProperty(value = 'shipping_address')
	ShippingAddress shippingAddress
}
