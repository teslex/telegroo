package tech.teslex.telegroo.telegram.api.types.payments;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderInfo {

	/**
	 * Optional. User name
	 */
	@JsonProperty(required = false)
	private String name;
	/**
	 * Optional. User's phone number
	 */
	@JsonProperty(value = "phone_number", required = false)
	private String phoneNumber;
	/**
	 * Optional. User email
	 */
	@JsonProperty(required = false)
	private String email;
	/**
	 * Optional. User shipping address
	 */
	@JsonProperty(value = "shipping_address", required = false)
	private ShippingAddress shippingAddress;
}
