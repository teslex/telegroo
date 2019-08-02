package tech.teslex.telegroo.telegram.api.types.payments;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShippingAddress {

	/**
	 * ISO 3166-1 alpha-2 country code
	 */
	@JsonProperty(value = "country_code")
	private String countryCode;
	/**
	 * State, if applicable
	 */
	private String state;
	/**
	 * City
	 */
	private String city;
	/**
	 * First line for the address
	 */
	@JsonProperty(value = "street_line1")
	private String streetLine1;
	/**
	 * Second line for the address
	 */
	@JsonProperty(value = "street_line2")
	private String streetLine2;
	/**
	 * Address post code
	 */
	@JsonProperty(value = "post_code")
	private String postCode;
}
