package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObjectWithFile;
import tech.teslex.telegroo.telegram.attach.InputFile;

/**
 * sendAudio
 * Use this method to send audio files, if you want Telegram clients to display them in the music player. Your audio must be in the .mp3 format. On success, the sent Message is returned. Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.
 * <p>
 * For sending voice messages, use the sendVoice method instead.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendAudio implements MethodObjectWithFile {
	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * Audio file to send. Pass a file_id as String to send an audio file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an audio file from the Internet, or upload a new one using multipart/form-data. More info on Sending Files »
	 */
	@JsonIgnore
	private InputFile audio;
	/**
	 * Audio caption, 0-1024 characters
	 */
	@JsonProperty(required = false)
	private String caption;
	/**
	 * Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
	 */
	@JsonProperty(value = "parse_mode", required = false)
	private String parseMode;
	/**
	 * Duration of the audio in seconds
	 */
	@JsonProperty(required = false)
	private Integer duration;
	/**
	 * Performer
	 */
	@JsonProperty(required = false)
	private String performer;
	/**
	 * Track name
	 */
	@JsonProperty(required = false)
	private String title;
	/**
	 * Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 90. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>. More info on Sending Files »
	 */
	@JsonIgnore
	private InputFile thumb;
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

	public static SendAudio create() {
		return new SendAudio();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "sendPhoto";
	}

	@Override
	@JsonIgnore
	public InputFile getInputFile() {
		return this.audio;
	}

	public SendAudio chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public SendAudio audio(InputFile audio) {
		this.audio = audio;
		return this;
	}

	public SendAudio caption(String caption) {
		this.caption = caption;
		return this;
	}

	public SendAudio parseMode(String parseMode) {
		this.parseMode = parseMode;
		return this;
	}

	public SendAudio duration(Integer duration) {
		this.duration = duration;
		return this;
	}

	public SendAudio performer(String performer) {
		this.performer = performer;
		return this;
	}

	public SendAudio title(String title) {
		this.title = title;
		return this;
	}

	public SendAudio thumb(InputFile thumb) {
		this.thumb = thumb;
		return this;
	}

	public SendAudio disableNotification(Boolean disableNotification) {
		this.disableNotification = disableNotification;
		return this;
	}

	public SendAudio replyToMessageId(Integer replyToMessageId) {
		this.replyToMessageId = replyToMessageId;
		return this;
	}

	public SendAudio replyMarkup(Object replyMarkup) {
		this.replyMarkup = replyMarkup;
		return this;
	}
}
