package tech.teslex.telegroo.telegram.types.inline


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.TypeAnnotations
import tech.teslex.telegroo.telegram.types.InlineKeyboardMarkup

/**
 * Represents a link to a photo stored on the Telegram servers. By default, this photo will be sent by the user with an optional caption. Alternatively, you can use input_message_content to send a message with the specified content instead of the photo.
 */
@TypeAnnotations
class InlineQueryResultCachedPhoto extends InlineQueryResult {

	/**
	 * Type of the result, must be photo
	 */
	String type = 'photo'

	/**
	 * Unique identifier for this result, 1-64 bytes
	 */
	String id

	/**
	 * A valid file identifier of the photo
	 */
	@JsonProperty(value = 'photo_file_id')
	String photoFileId

	/**
	 * Optional. Title for the result
	 */
	@JsonProperty(required = false)
	String title

	/**
	 * Optional. Short description of the result
	 */
	@JsonProperty(required = false)
	String description

	/**
	 * Optional. Caption of the photo to be sent, 0-1024 characters
	 */
	@JsonProperty(required = false)
	String caption

	/**
	 * Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
	 */
	@JsonProperty(value = 'parse_mode', required = false)
	String parseMode

	/**
	 * Optional. Inline keyboard attached to the message
	 */
	@JsonProperty(value = 'reply_markup', required = false)
	InlineKeyboardMarkup replyMarkup

	/**
	 * Optional. Content of the message to be sent instead of the photo
	 */
	@JsonProperty(value = 'input_message_content', required = false)
	InputMessageContent inputMessageContent
}
