package tech.teslex.telegroo.telegram.api.types.inline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents the content of a location message to be sent as the result of an inline query.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InputLocationMessageContent extends InputMessageContent {
	/**
	 * Latitude of the location in degrees
	 */
	private Float latitude;
	/**
	 * Longitude of the location in degrees
	 */
	private Float longitude;
	/**
	 * Optional. Period in seconds for which the location can be updated, should be between 60 and 86400.
	 */
	@JsonProperty(value = "live_period", required = false)
	private Integer livePeriod;
}
