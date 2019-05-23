package tech.teslex.telegroo.telegram.api.types.inline


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.api.TypeAnnotations

/**
 * Represents the content of a location message to be sent as the result of an inline query.
 */
@TypeAnnotations
class InputLocationMessageContent extends InputMessageContent {

	/**
	 * Latitude of the location in degrees
	 */
	Float latitude

	/**
	 * Longitude of the location in degrees
	 */
	Float longitude

	/**
	 * Optional. Period in seconds for which the location can be updated, should be between 60 and 86400.
	 */
	@JsonProperty(value = 'live_period', required = false)
	Integer livePeriod
}
