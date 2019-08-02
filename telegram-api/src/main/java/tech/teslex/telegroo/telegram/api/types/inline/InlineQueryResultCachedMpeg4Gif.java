package tech.teslex.telegroo.telegram.api.types.inline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup;

/**
 * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound) stored on the Telegram servers. By default, this animated MPEG-4 file will be sent by the user with an optional caption. Alternatively, you can use input_message_content to send a message with the specified content instead of the animation.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InlineQueryResultCachedMpeg4Gif extends InlineQueryResult {
	/**
	 * Type of the result, must be mpeg4_gif
	 */
	private String type = "mpeg4_gif";
	/**
	 * Unique identifier for this result, 1-64 bytes
	 */
	private String id;
	/**
	 * A valid file identifier for the MP4 file
	 */
	@JsonProperty(value = "mpeg4_file_id")
	private String mpeg4FileId;
	/**
	 * Optional. Title for the result
	 */
	@JsonProperty(required = false)
	private String title;
	/**
	 * Optional. Caption of the MPEG-4 file to be sent, 0-1024 characters
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
	 * Optional. Content of the message to be sent instead of the video animation
	 */
	@JsonProperty(value = "input_message_content", required = false)
	private InputMessageContent inputMessageContent;
}
