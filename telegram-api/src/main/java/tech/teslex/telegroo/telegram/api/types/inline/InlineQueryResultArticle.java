package tech.teslex.telegroo.telegram.api.types.inline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup;

/**
 * Represents a link to an article or web page.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InlineQueryResultArticle extends InlineQueryResult {
	/**
	 * Type of the result, must be article
	 */
	private String type = "article";
	/**
	 * Unique identifier for this result, 1-64 Bytes
	 */
	private String id;
	/**
	 * Title of the result
	 */
	private String title;
	/**
	 * Content of the message to be sent
	 */
	@JsonProperty(value = "input_message_content")
	private InputMessageContent inputMessageContent;
	/**
	 * Optional. Inline keyboard attached to the message
	 */
	@JsonProperty(value = "reply_markup", required = false)
	private InlineKeyboardMarkup replyMarkup;
	/**
	 * Optional. URL of the result
	 */
	@JsonProperty(required = false)
	private String url;
	/**
	 * Optional. Pass True, if you don't want the URL to be shown in the message
	 */
	@JsonProperty(value = "hide_url", required = false)
	private Boolean hideUrl;
	/**
	 * Optional. Short description of the result
	 */
	@JsonProperty(required = false)
	private String description;
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
