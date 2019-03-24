package tech.teslex.telegroo.telegram.types


import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.builder.Builder
import tech.teslex.telegroo.telegram.TypeAnnotations

@Builder
@TypeAnnotations
class KeyboardButton {

	/**
	 * Text of the button. If none of the optional fields are used, it will be sent as a message when the button is pressed
	 */
	String text

	/**
	 * Optional. If True, the user's phone number will be sent as a contact when the button is pressed. Available in private chats only
	 */
	@JsonProperty(value = 'request_contact', required = false)
	Boolean requestContact

	/**
	 * Optional. If True, the user's current location will be sent when the button is pressed. Available in private chats only
	 */
	@JsonProperty(value = 'request_location', required = false)
	Boolean requestLocation
}
