package tech.teslex.telegroo.telegram.api.types.inline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup;

/**
 * Represents a link to a photo. By default, this photo will be sent by the user with optional caption. Alternatively, you can use input_message_content to send a message with the specified content instead of the photo.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InlineQueryResultPhoto extends InlineQueryResult {
	/**
	 * Type of the result, must be photo
	 */
	private String type = "photo";
	/**
	 * Unique identifier for this result, 1-64 bytes
	 */
	private String id;
	/**
	 * A valid URL of the photo. Photo must be in jpeg format. Photo size must not exceed 5MB
	 */
	@JsonProperty(value = "photo_url")
	private String photoUrl;
	/**
	 * URL of the thumbnail for the photo
	 */
	@JsonProperty(value = "thumb_url")
	private String thumbUrl;
	/**
	 * Optional. Width of the photo
	 */
	@JsonProperty(value = "photo_width", required = false)
	private Integer photoWidth;
	/**
	 * Optional. Height of the photo
	 */
	@JsonProperty(value = "photo_height", required = false)
	private Integer photoHeight;
	/**
	 * Optional. Title for the result
	 */
	@JsonProperty(required = false)
	private String title;
	/**
	 * Optional. Short description of the result
	 */
	@JsonProperty(required = false)
	private String description;
	/**
	 * Optional. Caption of the photo to be sent, 0-1024 characters
	 */
	@JsonProperty(required = false)
	private String caption;
	/**
	 * Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
	 */
	@JsonProperty(value = "parse_mode", required = false)
	private String parseMode;
	/**
	 * Optional. Inline keyboard attached to the message
	 */
	@JsonProperty(value = "reply_markup", required = false)
	private InlineKeyboardMarkup replyMarkup;
	/**
	 * Optional. Content of the message to be sent instead of the photo
	 */
	@JsonProperty(value = "input_message_content", required = false)
	private InputMessageContent inputMessageContent;
}
