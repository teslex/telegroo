package tech.teslex.telegroo.telegram.api.types.inline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup;

/**
 * Represents a link to a page containing an embedded video player or a video file. By default, this video file will be sent by the user with an optional caption. Alternatively, you can use input_message_content to send a message with the specified content instead of the video.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InlineQueryResultVideo extends InlineQueryResult {
	/**
	 * Type of the result, must be video
	 */
	private String type = "video";
	/**
	 * Unique identifier for this result, 1-64 bytes
	 */
	private String id;
	/**
	 * A valid URL for the embedded video player or video file
	 */
	@JsonProperty(value = "video_url")
	private String videoUrl;
	/**
	 * Mime value of the content of video url, “text/html” or “video/mp4”
	 */
	@JsonProperty(value = "mime_type")
	private String mimeType;
	/**
	 * URL of the thumbnail (jpeg only) for the video
	 */
	@JsonProperty(value = "thumb_url")
	private String thumbUrl;
	/**
	 * Title for the result
	 */
	private String title;
	/**
	 * Optional. Caption of the video to be sent, 0-1024 characters
	 */
	@JsonProperty(required = false)
	private String caption;
	/**
	 * Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
	 */
	@JsonProperty(value = "parse_mode", required = false)
	private String parseMode;
	/**
	 * Optional. Video width
	 */
	@JsonProperty(value = "video_width", required = false)
	private Integer videoWidth;
	/**
	 * Optional. Video height
	 */
	@JsonProperty(value = "video_height", required = false)
	private Integer videoHeight;
	/**
	 * Optional. Video duration in seconds
	 */
	@JsonProperty(value = "video_duration", required = false)
	private Integer videoDuration;
	/**
	 * Optional. Short description of the result
	 */
	@JsonProperty(required = false)
	private String description;
	/**
	 * Optional. Inline keyboard attached to the message
	 */
	@JsonProperty(value = "reply_markup", required = false)
	private InlineKeyboardMarkup replyMarkup;
	/**
	 * Optional. Content of the message to be sent instead of the video. This field is required if InlineQueryResultVideo is used to send an HTML-page as a result (e.g., a YouTube video).
	 */
	@JsonProperty(value = "input_message_content", required = false)
	private InputMessageContent inputMessageContent;
}
