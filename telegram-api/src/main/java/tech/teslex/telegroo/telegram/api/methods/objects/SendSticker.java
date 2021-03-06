package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;
import tech.teslex.telegroo.telegram.attach.InputFile;

/**
 * sendSticker
 * Use this method to send .webp stickers. On success, the sent Message is returned.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendSticker implements MethodObject {
	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * Sticker to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a .webp file from the Internet, or upload a new one using multipart/form-data. More info on Sending Files »
	 */
	@JsonProperty(required = true)
	private InputFile sticker;
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

	public static SendSticker create() {
		return new SendSticker();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "sendSticker";
	}

	public SendSticker chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public SendSticker sticker(InputFile sticker) {
		this.sticker = sticker;
		return this;
	}

	public SendSticker disableNotification(Boolean disableNotification) {
		this.disableNotification = disableNotification;
		return this;
	}

	public SendSticker replyToMessageId(Integer replyToMessageId) {
		this.replyToMessageId = replyToMessageId;
		return this;
	}

	public SendSticker replyMarkup(Object replyMarkup) {
		this.replyMarkup = replyMarkup;
		return this;
	}
}
