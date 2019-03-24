package tech.teslex.telegroo.telegram.types.payments


import tech.teslex.telegroo.telegram.TypeAnnotations

@TypeAnnotations
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
