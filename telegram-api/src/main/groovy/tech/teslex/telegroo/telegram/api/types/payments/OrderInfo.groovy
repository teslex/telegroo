package tech.teslex.telegroo.telegram.api.types.payments


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.api.TypeAnnotations

@TypeAnnotations
class OrderInfo {

	/**
	 * Optional. User name
	 */
	@JsonProperty(required = false)
	String name

	/**
	 * Optional. User's phone number
	 */
	@JsonProperty(value = 'phone_number', required = false)
	String phoneNumber

	/**
	 * Optional. User email
	 */
	@JsonProperty(required = false)
	String email

	/**
	 * Optional. User shipping address
	 */
	@JsonProperty(value = 'shipping_address', required = false)
	ShippingAddress shippingAddress
}
