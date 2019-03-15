package tech.teslex.telegroo.telegram.types.inline

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.Canonical
import groovy.transform.builder.Builder
import tech.teslex.telegroo.telegram.types.InlineKeyboardMarkup

/**
 * Represents a location on a map. By default, the location will be sent by the user. Alternatively, you can use input_message_content to send a message with the specified content instead of the location.
 */
@Canonical
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class InlineQueryResultLocation extends InlineQueryResult {

	/**
	 * Type of the result, must be location
	 */
	String type

	/**
	 * Unique identifier for this result, 1-64 Bytes
	 */
	String id

	/**
	 * Location latitude in degrees
	 */
	Float latitude

	/**
	 * Location longitude in degrees
	 */
	Float longitude

	/**
	 * Location title
	 */
	String title

	/**
	 * Optional. Period in seconds for which the location can be updated, should be between 60 and 86400.
	 */
	@JsonProperty(value = 'live_period', required = false)
	Integer livePeriod

	/**
	 * Optional. Inline keyboard attached to the message
	 */
	@JsonProperty(value = 'reply_markup', required = false)
	InlineKeyboardMarkup replyMarkup

	/**
	 * Optional. Content of the message to be sent instead of the location
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
