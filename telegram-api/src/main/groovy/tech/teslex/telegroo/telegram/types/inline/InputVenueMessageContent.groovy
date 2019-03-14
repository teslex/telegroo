package tech.teslex.telegroo.telegram.types.inline

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.ToString
import groovy.transform.builder.Builder

/**
 * Represents the content of a venue message to be sent as the result of an inline query.
 */
@Builder
@ToString
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class InputVenueMessageContent extends InputMessageContent {

	/**
	 * Latitude of the venue in degrees
	 */
	Float latitude

	/**
	 * Longitude of the venue in degrees
	 */
	Float longitude

	/**
	 * Name of the venue
	 */
	String title

	/**
	 * Address of the venue
	 */
	String address

	/**
	 * Optional. Foursquare identifier of the venue, if known
	 */
	@JsonProperty(value = 'foursquare_id', required = false)
	String foursquareId

	/**
	 * Optional. Foursquare type of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
	 */
	@JsonProperty(value = 'foursquare_type', required = false)
	String foursquareType
}
