package tech.teslex.telegroo.telegram.types

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class Venue {

	/**
	 * Venue location
	 */
	Location location

	/**
	 * Name of the venue
	 */
	String title

	/**
	 * Address of the venue
	 */
	String address

	/**
	 * Optional. Foursquare identifier of the venue
	 */
	@JsonProperty(value = 'foursquare_id', required = false)
	String foursquareId

	/**
	 * Optional. Foursquare type of the venue. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
	 */
	@JsonProperty(value = 'foursquare_type', required = false)
	String foursquareType
}
