package tech.teslex.telegroo.telegram.api.types.payments;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.types.User;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShippingQuery {

	/**
	 * Unique query identifier
	 */
	private String id;
	/**
	 * User who sent the query
	 */
	private User from;
	/**
	 * Bot specified invoice payload
	 */
	@JsonProperty(value = "invoice_payload")
	private String invoicePayload;
	/**
	 * User specified shipping address
	 */
	@JsonProperty(value = "shipping_address")
	private ShippingAddress shippingAddress;
}
