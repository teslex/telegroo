package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * sendMessage
 * Use this method to send text messages. On success, the sent Message is returned.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendMessageMethodObject implements MethodObject {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * Text of the message to be sent
	 */
	@JsonProperty(required = true)
	private String text;
	/**
	 * Disables link previews for links in this message
	 */
	@JsonProperty(value = "disable_web_page_preview", required = false)
	private Boolean disableWebPagePreview;
	/**
	 * Sends the message silently. Users will receive a notification with no sound.
	 */
	@JsonProperty(value = "disable_notification", required = false)
	private Boolean disableNotification;
	/**
	 * If the message is a reply, ID of the original message
	 */
	@JsonProperty(value = "reply_to_message_id", required = false)
	private Integer replyToMessageId;
	/**
	 * Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
	 * <p>
	 * InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply
	 */
	@JsonProperty(value = "reply_markup", required = false)
	private Object replyMarkup;
	/**
	 * Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in your bot's message.
	 */
	@JsonProperty(value = "parse_mode", required = false)
	private String parseMode;

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "sendMessage";
	}
}
