package tech.teslex.telegroo.telegram.api.types.payments;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Invoice {

	/**
	 * Product name
	 */
	private String title;
	/**
	 * Product description
	 */
	private String description;
	/**
	 * Unique bot deep-linking parameter that can be used to generate this invoice
	 */
	@JsonProperty(value = "start_parameter")
	private String startParameter;
	/**
	 * Three-letter ISO 4217 currency code
	 */
	private String currency;
	/**
	 * Total price in the smallest units of the currency (integer, not float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
	 */
	@JsonProperty(value = "total_amount")
	private Integer totalAmount;
}
