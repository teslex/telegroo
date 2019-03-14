package tech.teslex.telegroo.telegram.types

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class User {

	/**
	 * Unique identifier for this user or bot
	 */
	Integer id

	/**
	 * True, if this user is a bot
	 */
	@JsonProperty(value = 'is_bot')
	Boolean isBot

	/**
	 * User‘s or bot’s first name
	 */
	@JsonProperty(value = 'first_name')
	String firstName

	/**
	 * Optional. User‘s or bot’s last name
	 */
	@JsonProperty(value = 'last_name', required = false)
	String lastName

	/**
	 * Optional. User‘s or bot’s username
	 */
	@JsonProperty(required = false)
	String username

	/**
	 * Optional. IETF language tag of the user's language
	 */
	@JsonProperty(value = 'language_code', required = false)
	String languageCode
}
