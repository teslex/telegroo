package tech.teslex.telegroo.telegram.types.inline


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.TypeAnnotations
import tech.teslex.telegroo.telegram.types.InlineKeyboardMarkup

/**
 * Represents a contact with a phone number. By default, this contact will be sent by the user. Alternatively, you can use input_message_content to send a message with the specified content instead of the contact.
 */
@TypeAnnotations
class InlineQueryResultContact extends InlineQueryResult {

	/**
	 * Type of the result, must be contact
	 */
	String type

	/**
	 * Unique identifier for this result, 1-64 Bytes
	 */
	String id

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

	/**
	 * Optional. Inline keyboard attached to the message
	 */
	@JsonProperty(value = 'reply_markup', required = false)
	InlineKeyboardMarkup replyMarkup

	/**
	 * Optional. Content of the message to be sent instead of the contact
	 */
	@JsonProperty(value = 'input_message_content', required = false)
	InputMessageContent inputMessageContent

	/**
	 * Optional. Url of the thumbnail for the result
	 */
	@JsonProperty(value = 'thumb_url', required = false)
	String thumbUrl

	/**
	 * Optional. Thumbnail width
	 */
	@JsonProperty(value = 'thumb_width', required = false)
	Integer thumbWidth

	/**
	 * Optional. Thumbnail height
	 */
	@JsonProperty(value = 'thumb_height', required = false)
	Integer thumbHeight
}
