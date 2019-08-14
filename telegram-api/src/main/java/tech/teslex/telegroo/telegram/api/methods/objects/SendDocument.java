package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObjectWithFile;
import tech.teslex.telegroo.telegram.attach.InputFile;

/**
 * sendDocument
 * Use this method to send general files. On success, the sent Message is returned. Bots can currently send files of any value of up to 50 MB in size, this limit may be changed in the future.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendDocument implements MethodObjectWithFile {
	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * File to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. More info on Sending Files »
	 */
	@JsonIgnore
	private InputFile document;
	/**
	 * Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 90. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>. More info on Sending Files »
	 */
	@JsonIgnore
	private InputFile thumb;
	/**
	 * Document caption (may also be used when resending documents by file_id), 0-1024 characters
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
	 * Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
	 * <p>
	 * InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply
	 */
	@JsonProperty(value = "reply_markup", required = false)
	private Object replyMarkup;

	public static SendDocument create() {
		return new SendDocument();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "sendDocument";
	}

	@Override
	@JsonIgnore
	public InputFile getInputFile() {
		return this.document;
	}

	public SendDocument chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public SendDocument document(InputFile document) {
		this.document = document;
		return this;
	}

	public SendDocument thumb(InputFile thumb) {
		this.thumb = thumb;
		return this;
	}

	public SendDocument caption(String caption) {
		this.caption = caption;
		return this;
	}

	public SendDocument parseMode(String parseMode) {
		this.parseMode = parseMode;
		return this;
	}

	public SendDocument disableNotification(Boolean disableNotification) {
		this.disableNotification = disableNotification;
		return this;
	}

	public SendDocument replyMarkup(Object replyMarkup) {
		this.replyMarkup = replyMarkup;
		return this;
	}
}
