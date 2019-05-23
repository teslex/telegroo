package tech.teslex.telegroo.telegram.api.types.inline


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.api.TypeAnnotations

/**
 * Represents the content of a venue message to be sent as the result of an inline query.
 */
@TypeAnnotations
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
	 * Optional. Foursquare value of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
	 */
	@JsonProperty(value = 'foursquare_type', required = false)
	String foursquareType
}
