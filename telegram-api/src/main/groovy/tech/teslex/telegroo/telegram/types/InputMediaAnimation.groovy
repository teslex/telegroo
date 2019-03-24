package tech.teslex.telegroo.telegram.types

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.TypeAnnotations

@TypeAnnotations
class InputMediaAnimation extends InputMedia {

	/**
	 * Type of the result, must be animation
	 */
	String type = 'animation'

	/**
	 * File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://<file_attach_name>” to upload a new one using multipart/form-data under <file_attach_name> name. More info on Sending Files »
	 */
	@JsonIgnore
	InputFile media

	/**
	 * Optional. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 90. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>. More info on Sending Files »
	 */
	@JsonIgnore
	InputFile thumb

	/**
	 * Optional. Caption of the animation to be sent, 0-1024 characters
	 */
	@JsonProperty(required = false)
	String caption

	/**
	 * Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
	 */
	@JsonProperty(value = 'parse_mode', required = false)
	String parseMode

	/**
	 * Optional. Animation width
	 */
	@JsonProperty(required = false)
	Integer width

	/**
	 * Optional. Animation height
	 */
	@JsonProperty(required = false)
	Integer height

	/**
	 * Optional. Animation duration
	 */
	@JsonProperty(required = false)
	Integer duration
}
