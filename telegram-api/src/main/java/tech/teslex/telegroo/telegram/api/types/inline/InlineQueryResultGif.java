package tech.teslex.telegroo.telegram.api.types.inline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup;

/**
 * description
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InlineQueryResultGif extends InlineQueryResult {
	/**
	 * Type of the result, must be gif
	 */
	private String type = "gif";
	/**
	 * Unique identifier for this result, 1-64 bytes
	 */
	private String id;
	/**
	 * A valid URL for the GIF file. File size must not exceed 1MB
	 */
	@JsonProperty(value = "gif_url")
	private String gifUrl;
	/**
	 * Optional. Width of the GIF
	 */
	@JsonProperty(value = "gif_width", required = false)
	private Integer gifWidth;
	/**
	 * Optional. Height of the GIF
	 */
	@JsonProperty(value = "gif_height", required = false)
	private Integer gifHeight;
	/**
	 * Optional. Duration of the GIF
	 */
	@JsonProperty(value = "gif_duration", required = false)
	private Integer gifDuration;
	/**
	 * URL of the static thumbnail for the result (jpeg or gif)
	 */
	@JsonProperty(value = "thumb_url")
	private String thumbUrl;
	/**
	 * Optional. Title for the result
	 */
	@JsonProperty(required = false)
	private String title;
	/**
	 * Optional. Caption of the GIF file to be sent, 0-1024 characters
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
	 * Optional. Content of the message to be sent instead of the GIF animation
	 */
	@JsonProperty(value = "input_message_content", required = false)
	private InputMessageContent inputMessageContent;
}
