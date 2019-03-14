package tech.teslex.telegroo.telegram.types.inline

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.ToString
import groovy.transform.builder.Builder

/**
 * Represents the content of a location message to be sent as the result of an inline query.
 */
@Builder
@ToString
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
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
