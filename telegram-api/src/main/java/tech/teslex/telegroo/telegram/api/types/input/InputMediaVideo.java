package tech.teslex.telegroo.telegram.api.types.input;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tech.teslex.telegroo.telegram.attach.InputFile;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InputMediaVideo extends InputMedia {
	/**
	 * Type of the result, must be video
	 */
	@Builder.Default
	private String type = "video";
	/**
	 * File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://<file_attach_name>” to upload a new one using multipart/form-data under <file_attach_name> name. More info on Sending Files »
	 */
	@JsonIgnore
	private InputFile media;
	/**
	 * Optional. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 90. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>. More info on Sending Files »
	 */
	@JsonIgnore
	private InputFile thumb;
	/**
	 * Optional. Caption of the video to be sent, 0-1024 characters
	 */
	@JsonProperty(required = false)
	private String caption;
	/**
	 * Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
	 */
	@JsonProperty(value = "parse_mode", required = false)
	private String parseMode;
	/**
	 * Optional. Video width
	 */
	@JsonProperty(required = false)
	private Integer width;
	/**
	 * Optional. Video height
	 */
	@JsonProperty(required = false)
	private Integer height;
	/**
	 * Optional. Video duration
	 */
	@JsonProperty(required = false)
	private Integer duration;
	/**
	 * Optional. Pass True, if the uploaded video is suitable for streaming
	 */
	@JsonProperty(value = "supports_streaming", required = false)
	private Boolean supportsStreaming;
}
