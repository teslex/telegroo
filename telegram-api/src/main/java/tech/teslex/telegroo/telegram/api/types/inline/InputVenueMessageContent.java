package tech.teslex.telegroo.telegram.api.types.inline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents the content of a venue message to be sent as the result of an inline query.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InputVenueMessageContent extends InputMessageContent {
	/**
	 * Latitude of the venue in degrees
	 */
	private Float latitude;
	/**
	 * Longitude of the venue in degrees
	 */
	private Float longitude;
	/**
	 * Name of the venue
	 */
	private String title;
	/**
	 * Address of the venue
	 */
	private String address;
	/**
	 * Optional. Foursquare identifier of the venue, if known
	 */
	@JsonProperty(value = "foursquare_id", required = false)
	private String foursquareId;
	/**
	 * Optional. Foursquare value of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
	 */
	@JsonProperty(value = "foursquare_type", required = false)
	private String foursquareType;
}
