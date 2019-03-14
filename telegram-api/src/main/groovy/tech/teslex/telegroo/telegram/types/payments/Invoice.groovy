package tech.teslex.telegroo.telegram.types.payments

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class Invoice {

	/**
	 * Product name
	 */
	String title

	/**
	 * Product description
	 */
	String description

	/**
	 * Unique bot deep-linking parameter that can be used to generate this invoice
	 */
	@JsonProperty(value = 'start_parameter')
	String startParameter

	/**
	 * Three-letter ISO 4217 currency code
	 */
	String currency

	/**
	 * Total price in the smallest units of the currency (integer, not float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
	 */
	@JsonProperty(value = 'total_amount')
	Integer totalAmount
}
