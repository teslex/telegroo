package tech.teslex.telegroo.telegram.types.inline


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.TypeAnnotations
import tech.teslex.telegroo.telegram.types.InlineKeyboardMarkup

/**
 * Represents a link to an article or web page.
 */
@TypeAnnotations
class InlineQueryResultArticle extends InlineQueryResult {

	/**
	 * Type of the result, must be article
	 */
	String type

	/**
	 * Unique identifier for this result, 1-64 Bytes
	 */
	String id

	/**
	 * Title of the result
	 */
	String title

	/**
	 * Content of the message to be sent
	 */
	@JsonProperty(value = 'input_message_content')
	InputMessageContent inputMessageContent

	/**
	 * Optional. Inline keyboard attached to the message
	 */
	@JsonProperty(value = 'reply_markup', required = false)
	InlineKeyboardMarkup replyMarkup

	/**
	 * Optional. URL of the result
	 */
	@JsonProperty(required = false)
	String url

	/**
	 * Optional. Pass True, if you don't want the URL to be shown in the message
	 */
	@JsonProperty(value = 'hide_url', required = false)
	Boolean hideUrl

	/**
	 * Optional. Short description of the result
	 */
	@JsonProperty(required = false)
	String description

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
