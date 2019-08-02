package tech.teslex.telegroo.telegram.api.types.payments;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShippingOption {

	/**
	 * Shipping option identifier
	 */
	private String id;
	/**
	 * Option title
	 */
	private String title;
	/**
	 * List of price portions
	 */
	private List<LabeledPrice> prices;
}
