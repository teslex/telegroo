package tech.teslex.telegroo.telegram.api.types.inline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents the content of a text message to be sent as the result of an inline query.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InputTextMessageContent extends InputMessageContent {
	/**
	 * Text of the message to be sent, 1-4096 characters
	 */
	@JsonProperty(value = "message_text")
	private String messageText;
	/**
	 * Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in your bot's message.
	 */
	@JsonProperty(value = "parse_mode", required = false)
	private String parseMode;
	/**
	 * Optional. Disables link previews for links in the sent message
	 */
	@JsonProperty(value = "disable_web_page_preview", required = false)
	private Boolean disableWebPagePreview;
}
