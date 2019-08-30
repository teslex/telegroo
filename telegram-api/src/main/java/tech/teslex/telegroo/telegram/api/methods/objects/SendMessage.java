package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObjectWithDefaultParams;
import tech.teslex.telegroo.telegram.api.types.update.Update;
import tech.teslex.telegroo.telegram.enums.ParseMode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * sendMessage
 * Use this method to send text messages. On success, the sent Message is returned.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendMessage implements MethodObjectWithDefaultParams {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	@NotNull
	private Object chatId;
	/**
	 * Text of the message to be sent
	 */
	@JsonProperty(required = true)
	@NotBlank
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

	public static SendMessage create() {
		return new SendMessage();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "sendMessage";
	}

	public SendMessage chatId(@NotNull Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public SendMessage text(@NotBlank String text) {
		this.text = text;
		return this;
	}

	public SendMessage disableWebPagePreview(@NotNull boolean disableWebPagePreview) {
		this.disableWebPagePreview = disableWebPagePreview;
		return this;
	}

	public SendMessage disableNotification(@NotNull boolean disableNotification) {
		this.disableNotification = disableNotification;
		return this;
	}

	public SendMessage replyToMessageId(@NotNull int replyToMessageId) {
		this.replyToMessageId = replyToMessageId;
		return this;
	}

	public SendMessage replyMarkup(@NotNull Object replyMarkup) {
		this.replyMarkup = replyMarkup;
		return this;
	}

	public SendMessage parseMode(@NotBlank String parseMode) {
		this.parseMode = parseMode;
		return this;
	}

	public SendMessage parseMode(@NotNull ParseMode parseMode) {
		this.parseMode = parseMode.getValue();
		return this;
	}

	@Override
	public void useDefault(@NotNull Update update) {
		if (update.getMessage() != null && update.getMessage().getChat() != null && update.getMessage().getChat().getId() != null)
			if (this.getChatId() == null)
				this.setChatId(update.getMessage().getChat().getId());
	}
}
