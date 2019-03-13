package tech.teslex.telegroo.telegram.types

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
class MessageEntity {

	/**
	 * Type of the entity. Can be mention (@username), hashtag, cashtag, bot_command, url, email, phone_number, bold (bold text), italic (italic text), code (monowidth string), pre (monowidth block), text_link (for clickable text URLs), text_mention (for users without usernames)
	 */
	String type

	/**
	 * Offset in UTF-16 code units to the start of the entity
	 */
	Integer offset

	/**
	 * Length of the entity in UTF-16 code units
	 */
	Integer length

	/**
	 * Optional. For “text_link” only, url that will be opened after user taps on the text
	 */
	@JsonProperty(required = false)
	String url

	/**
	 * Optional. For “text_mention” only, the mentioned user
	 */
	@JsonProperty(required = false)
	User user
}
