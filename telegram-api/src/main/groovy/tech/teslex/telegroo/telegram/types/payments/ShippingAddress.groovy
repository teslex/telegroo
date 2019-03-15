package tech.teslex.telegroo.telegram.types.payments

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.Canonical

@Canonical
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class ShippingAddress {

	/**
	 * ISO 3166-1 alpha-2 country code
	 */
	@JsonProperty(value = 'country_code')
	String countryCode

	/**
	 * State, if applicable
	 */
	String state

	/**
	 * City
	 */
	String city

	/**
	 * First line for the address
	 */
	@JsonProperty(value = 'street_line1')
	String streetLine1

	/**
	 * Second line for the address
	 */
	@JsonProperty(value = 'street_line2')
	String streetLine2

	/**
	 * Address post code
	 */
	@JsonProperty(value = 'post_code')
	String postCode
}
