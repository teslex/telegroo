package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObjectWithFile;
import tech.teslex.telegroo.telegram.attach.InputFile;

/**
 * sendVideo
 * Use this method to send video files, Telegram clients support mp4 videos (other formats may be sent as Document). On success, the sent Message is returned. Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendVideo implements MethodObjectWithFile {
	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * Video to send. Pass a file_id as String to send a video that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a video from the Internet, or upload a new video using multipart/form-data. More info on Sending Files »
	 */
	@JsonIgnore
	private InputFile video;
	/**
	 * Duration of sent video in seconds
	 */
	@JsonProperty(required = false)
	private Integer duration;
	/**
	 * Video width
	 */
	@JsonProperty(required = false)
	private Integer width;
	/**
	 * Video height
	 */
	@JsonProperty(required = false)
	private Integer height;
	/**
	 * Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 90. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>. More info on Sending Files »
	 */
	@JsonIgnore
	private InputFile thumb;
	/**
	 * Video caption (may also be used when resending videos by file_id), 0-1024 characters
	 */
	@JsonProperty(required = false)
	private String caption;
	/**
	 * Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
	 */
	@JsonProperty(value = "parse_mode", required = false)
	private String parseMode;
	/**
	 * Pass True, if the uploaded video is suitable for streaming
	 */
	@JsonProperty(value = "supports_streaming", required = false)
	private Boolean supportsStreaming;
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

	public static SendVideo create() {
		return new SendVideo();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "sendVideo";
	}

	@Override
	@JsonIgnore
	public InputFile getInputFile() {
		return this.video;
	}

	public SendVideo chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public SendVideo video(InputFile video) {
		this.video = video;
		return this;
	}

	public SendVideo duration(Integer duration) {
		this.duration = duration;
		return this;
	}

	public SendVideo width(Integer width) {
		this.width = width;
		return this;
	}

	public SendVideo height(Integer height) {
		this.height = height;
		return this;
	}

	public SendVideo thumb(InputFile thumb) {
		this.thumb = thumb;
		return this;
	}

	public SendVideo caption(String caption) {
		this.caption = caption;
		return this;
	}

	public SendVideo parseMode(String parseMode) {
		this.parseMode = parseMode;
		return this;
	}

	public SendVideo supportsStreaming(Boolean supportsStreaming) {
		this.supportsStreaming = supportsStreaming;
		return this;
	}

	public SendVideo disableNotification(Boolean disableNotification) {
		this.disableNotification = disableNotification;
		return this;
	}

	public SendVideo replyToMessageId(Integer replyToMessageId) {
		this.replyToMessageId = replyToMessageId;
		return this;
	}

	public SendVideo replyMarkup(Object replyMarkup) {
		this.replyMarkup = replyMarkup;
		return this;
	}
}
