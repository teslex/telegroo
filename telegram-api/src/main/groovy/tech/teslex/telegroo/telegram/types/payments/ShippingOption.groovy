package tech.teslex.telegroo.telegram.types.payments

import com.fasterxml.jackson.annotation.JsonInclude
import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class ShippingOption {

	/**
	 * Shipping option identifier
	 */
	String id

	/**
	 * Option title
	 */
	String title

	/**
	 * List of price portions
	 */
	List<LabeledPrice> prices
}
