package tech.teslex.telegroo.telegram.types.payments

import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
class LabeledPrice {

	/**
	 * Portion label
	 */
	String label

	/**
	 * Price of the product in the smallest units of the currency (integer, not float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
	 */
	Integer amount
}
