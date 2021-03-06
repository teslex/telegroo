package tech.teslex.telegroo.telegram.api.types.inline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup;

/**
 * Represents a venue. By default, the venue will be sent by the user. Alternatively, you can use input_message_content to send a message with the specified content instead of the venue.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InlineQueryResultVenue extends InlineQueryResult {
	/**
	 * Type of the result, must be venue
	 */
	private String type = "venue";
	/**
	 * Unique identifier for this result, 1-64 Bytes
	 */
	private String id;
	/**
	 * Latitude of the venue location in degrees
	 */
	private Float latitude;
	/**
	 * Longitude of the venue location in degrees
	 */
	private Float longitude;
	/**
	 * Title of the venue
	 */
	private String title;
	/**
	 * Address of the venue
	 */
	private String address;
	/**
	 * Optional. Foursquare identifier of the venue if known
	 */
	@JsonProperty(value = "foursquare_id", required = false)
	private String foursquareId;
	/**
	 * Optional. Foursquare value of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
	 */
	@JsonProperty(value = "foursquare_type", required = false)
	private String foursquareType;
	/**
	 * Optional. Inline keyboard attached to the message
	 */
	@JsonProperty(value = "reply_markup", required = false)
	private InlineKeyboardMarkup replyMarkup;
	/**
	 * Optional. Content of the message to be sent instead of the venue
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
