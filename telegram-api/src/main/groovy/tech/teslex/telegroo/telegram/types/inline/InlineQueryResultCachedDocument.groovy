package tech.teslex.telegroo.telegram.types.inline

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.ToString
import groovy.transform.builder.Builder
import tech.teslex.telegroo.telegram.types.InlineKeyboardMarkup

/**
 * Represents a link to a file stored on the Telegram servers. By default, this file will be sent by the user with an optional caption. Alternatively, you can use input_message_content to send a message with the specified content instead of the file.
 */
@Builder
@ToString
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class InlineQueryResultCachedDocument extends InlineQueryResult {

	/**
	 * Type of the result, must be document
	 */
	String type

	/**
	 * Unique identifier for this result, 1-64 bytes
	 */
	String id

	/**
	 * Title for the result
	 */
	String title

	/**
	 * A valid file identifier for the file
	 */
	@JsonProperty(value = 'document_file_id')
	String documentFileId

	/**
	 * Optional. Short description of the result
	 */
	@JsonProperty(required = false)
	String description

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
	 * Optional. Inline keyboard attached to the message
	 */
	@JsonProperty(value = 'reply_markup', required = false)
	InlineKeyboardMarkup replyMarkup

	/**
	 * Optional. Content of the message to be sent instead of the file
	 */
	@JsonProperty(value = 'input_message_content', required = false)
	InputMessageContent inputMessageContent
}
