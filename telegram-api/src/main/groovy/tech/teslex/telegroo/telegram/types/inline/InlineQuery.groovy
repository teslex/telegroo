package tech.teslex.telegroo.telegram.types.inline

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.ToString
import groovy.transform.builder.Builder
import tech.teslex.telegroo.telegram.types.Location
import tech.teslex.telegroo.telegram.types.User

@Builder
@ToString
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class InlineQuery {

	/**
	 * Unique identifier for this query
	 */
	String id

	/**
	 * Sender
	 */
	User from

	/**
	 * Optional. Sender location, only for bots that request user location
	 */
	@JsonProperty(required = false)
	Location location

	/**
	 * Text of the query (up to 512 characters)
	 */
	String query

	/**
	 * Offset of the results to be returned, can be controlled by the bot
	 */
	String offset
}