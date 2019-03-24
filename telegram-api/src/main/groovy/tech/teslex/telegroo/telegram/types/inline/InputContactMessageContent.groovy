package tech.teslex.telegroo.telegram.types.inline


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.TypeAnnotations

/**
 * Represents the content of a contact message to be sent as the result of an inline query.
 */
@TypeAnnotations
class InputContactMessageContent extends InputMessageContent {

	/**
	 * Contact's phone number
	 */
	@JsonProperty(value = 'phone_number')
	String phoneNumber

	/**
	 * Contact's first name
	 */
	@JsonProperty(value = 'first_name')
	String firstName

	/**
	 * Optional. Contact's last name
	 */
	@JsonProperty(value = 'last_name', required = false)
	String lastName

	/**
	 * Optional. Additional data about the contact in the form of a vCard, 0-2048 bytes
	 */
	@JsonProperty(required = false)
	String vcard
}
