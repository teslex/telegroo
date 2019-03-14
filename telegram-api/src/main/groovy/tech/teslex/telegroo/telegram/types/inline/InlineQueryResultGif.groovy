package tech.teslex.telegroo.telegram.types.inline

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.ToString
import groovy.transform.builder.Builder
import tech.teslex.telegroo.telegram.types.InlineKeyboardMarkup

/**
 * description
 */
@Builder
@ToString
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class InlineQueryResultGif extends InlineQueryResult {

	/**
	 * Type of the result, must be gif
	 */
	String type

	/**
	 * Unique identifier for this result, 1-64 bytes
	 */
	String id

	/**
	 * A valid URL for the GIF file. File size must not exceed 1MB
	 */
	@JsonProperty(value = 'gif_url')
	String gifUrl

	/**
	 * Optional. Width of the GIF
	 */
	@JsonProperty(value = 'gif_width', required = false)
	Integer gifWidth

	/**
	 * Optional. Height of the GIF
	 */
	@JsonProperty(value = 'gif_height', required = false)
	Integer gifHeight

	/**
	 * Optional. Duration of the GIF
	 */
	@JsonProperty(value = 'gif_duration', required = false)
	Integer gifDuration

	/**
	 * URL of the static thumbnail for the result (jpeg or gif)
	 */
	@JsonProperty(value = 'thumb_url')
	String thumbUrl

	/**
	 * Optional. Title for the result
	 */
	@JsonProperty(required = false)
	String title

	/**
	 * Optional. Caption of the GIF file to be sent, 0-1024 characters
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
	 * Optional. Content of the message to be sent instead of the GIF animation
	 */
	@JsonProperty(value = 'input_message_content', required = false)
	InputMessageContent inputMessageContent
}
