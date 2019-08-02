package tech.teslex.telegroo.telegram.api.types.inline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup;

/**
 * Represents a link to a voice recording in an .ogg container encoded with OPUS. By default, this voice recording will be sent by the user. Alternatively, you can use input_message_content to send a message with the specified content instead of the the voice message.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InlineQueryResultVoice extends InlineQueryResult {
	/**
	 * Type of the result, must be voice
	 */
	private String type = "voice";
	/**
	 * Unique identifier for this result, 1-64 bytes
	 */
	private String id;
	/**
	 * A valid URL for the voice recording
	 */
	@JsonProperty(value = "voice_url")
	private String voiceUrl;
	/**
	 * Recording title
	 */
	private String title;
	/**
	 * Optional. Caption, 0-1024 characters
	 */
	@JsonProperty(required = false)
	private String caption;
	/**
	 * Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
	 */
	@JsonProperty(value = "parse_mode", required = false)
	private String parseMode;
	/**
	 * Optional. Recording duration in seconds
	 */
	@JsonProperty(value = "voice_duration", required = false)
	private Integer voiceDuration;
	/**
	 * Optional. Inline keyboard attached to the message
	 */
	@JsonProperty(value = "reply_markup", required = false)
	private InlineKeyboardMarkup replyMarkup;
	/**
	 * Optional. Content of the message to be sent instead of the voice recording
	 */
	@JsonProperty(value = "input_message_content", required = false)
	private InputMessageContent inputMessageContent;
}
