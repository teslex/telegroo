package tech.teslex.telegroo.telegram.api.types.inline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup;

/**
 * Represents a location on a map. By default, the location will be sent by the user. Alternatively, you can use input_message_content to send a message with the specified content instead of the location.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InlineQueryResultLocation extends InlineQueryResult {
	/**
	 * Type of the result, must be location
	 */
	private String type = "location";
	/**
	 * Unique identifier for this result, 1-64 Bytes
	 */
	private String id;
	/**
	 * Location latitude in degrees
	 */
	private Float latitude;
	/**
	 * Location longitude in degrees
	 */
	private Float longitude;
	/**
	 * Location title
	 */
	private String title;
	/**
	 * Optional. Period in seconds for which the location can be updated, should be between 60 and 86400.
	 */
	@JsonProperty(value = "live_period", required = false)
	private Integer livePeriod;
	/**
	 * Optional. Inline keyboard attached to the message
	 */
	@JsonProperty(value = "reply_markup", required = false)
	private InlineKeyboardMarkup replyMarkup;
	/**
	 * Optional. Content of the message to be sent instead of the location
	 */
	@JsonProperty(value = "input_message_content", required = false)
	private InputMessageContent inputMessageContent;
	/**
	 * Optional. Url of the thumbnail for the result
	 */
	@JsonProperty(value = "thumb_url", required = false)
	private String thumbUrl;
	/**
	 * Optional. Thumbnail width
	 */
	@JsonProperty(value = "thumb_width", required = false)
	private Integer thumbWidth;
	/**
	 * Optional. Thumbnail height
	 */
	@JsonProperty(value = "thumb_height", required = false)
	private Integer thumbHeight;
}
