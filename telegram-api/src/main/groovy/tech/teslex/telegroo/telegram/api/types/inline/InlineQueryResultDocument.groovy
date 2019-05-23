package tech.teslex.telegroo.telegram.api.types.inline


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.api.TypeAnnotations
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup

/**
 * Represents a link to a file. By default, this file will be sent by the user with an optional caption. Alternatively, you can use input_message_content to send a message with the specified content instead of the file. Currently, only .PDF and .ZIP files can be sent using this method.
 */
@TypeAnnotations
class InlineQueryResultDocument extends InlineQueryResult {

	/**
	 * Type of the result, must be document
	 */
	String type = 'document'

	/**
	 * Unique identifier for this result, 1-64 bytes
	 */
	String id

	/**
	 * Title for the result
	 */
	String title

	/**
	 * Optional. Caption of the document to be sent, 0-1024 characters
	 */
	@JsonProperty(required = false)
	String caption

	/**
	 * Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
	 */
	@JsonProperty(value = 'parse_mode', required = false)
	String parseMode

	/**
	 * A valid URL for the file
	 */
	@JsonProperty(value = 'document_url')
	String documentUrl

	/**
	 * Mime value of the content of the file, either “application/pdf” or “application/zip”
	 */
	@JsonProperty(value = 'mime_type')
	String mimeType

	/**
	 * Optional. Short description of the result
	 */
	@JsonProperty(required = false)
	String description

	/**
	 * Optional. Inline keyboard attached to the message
	 */
	@JsonProperty(value = 'reply_markup', required = false)
	InlineKeyboardMarkup replyMarkup

	/**
	 * Optional. Content of the message to be sent instead of the file
	 */
	@JsonProperty(value = 'input_message_content', required = false)
	InputMessageContent inputMessageContent

	/**
	 * Optional. URL of the thumbnail (jpeg only) for the file
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
