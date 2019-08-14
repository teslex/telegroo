package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObjectWithDefaultParams;
import tech.teslex.telegroo.telegram.api.methods.MethodObjectWithFile;
import tech.teslex.telegroo.telegram.api.types.update.Update;
import tech.teslex.telegroo.telegram.attach.InputFile;

import java.util.Objects;

/**
 * sendPhoto
 * Use this method to send photos. On success, the sent Message is returned.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendPhoto implements MethodObjectWithFile, MethodObjectWithDefaultParams {
	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 * <p>
	 * Integer or String
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * Photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet, or upload a new photo using multipart/form-data. More info on Sending Files »
	 */
	@JsonIgnore
	private InputFile photo;
	/**
	 * Photo caption (may also be used when resending photos by file_id), 0-1024 characters
	 */
	@JsonProperty(required = false)
	private String caption;
	/**
	 * Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
	 */
	@JsonProperty(value = "parse_mode", required = false)
	private String parseMode;
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

	public static SendPhoto create() {
		return new SendPhoto();
	}

	@Override
	@JsonIgnore
	public InputFile getInputFile() {
		return this.photo;
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "sendPhoto";
	}

	public SendPhoto chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public SendPhoto photo(InputFile photo) {
		this.photo = photo;
		return this;
	}

	public SendPhoto caption(String caption) {
		this.caption = caption;
		return this;
	}

	public SendPhoto parseMode(String parseMode) {
		this.parseMode = parseMode;
		return this;
	}

	public SendPhoto disableNotification(Boolean disableNotification) {
		this.disableNotification = disableNotification;
		return this;
	}

	public SendPhoto replyToMessageId(Integer replyToMessageId) {
		this.replyToMessageId = replyToMessageId;
		return this;
	}

	public SendPhoto replyMarkup(Object replyMarkup) {
		this.replyMarkup = replyMarkup;
		return this;
	}

	@Override
	public void useDefault(Update update) {
		Objects.requireNonNull(update);
		Objects.requireNonNull(update.getMessage());
		Objects.requireNonNull(update.getMessage().getChat());
		Objects.requireNonNull(update.getMessage().getChat().getId());

		if (this.getChatId() == null)
			this.setChatId(update.getMessage().getChat().getId());
	}
}
