package tech.teslex.telegroo.telegram.types.payments

import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
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