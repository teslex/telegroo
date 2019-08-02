package tech.teslex.telegroo.telegram.api.types.inline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup;

/**
 * Represents a link to a file. By default, this file will be sent by the user with an optional caption. Alternatively, you can use input_message_content to send a message with the specified content instead of the file. Currently, only .PDF and .ZIP files can be sent using this method.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InlineQueryResultDocument extends InlineQueryResult {
	/**
	 * Type of the result, must be document
	 */
	private String type = "document";
	/**
	 * Unique identifier for this result, 1-64 bytes
	 */
	private String id;
	/**
	 * Title for the result
	 */
	private String title;
	/**
	 * Optional. Caption of the document to be sent, 0-1024 characters
	 */
	@JsonProperty(required = false)
	private String caption;
	/**
	 * Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
	 */
	@JsonProperty(value = "parse_mode", required = false)
	private String parseMode;
	/**
	 * A valid URL for the file
	 */
	@JsonProperty(value = "document_url")
	private String documentUrl;
	/**
	 * Mime value of the content of the file, either “application/pdf” or “application/zip”
	 */
	@JsonProperty(value = "mime_type")
	private String mimeType;
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
	 * Optional. Content of the message to be sent instead of the file
	 */
	@JsonProperty(value = "input_message_content", required = false)
	private InputMessageContent inputMessageContent;
	/**
	 * Optional. URL of the thumbnail (jpeg only) for the file
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
