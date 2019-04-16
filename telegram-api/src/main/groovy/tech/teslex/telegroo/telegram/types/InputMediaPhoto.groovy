package tech.teslex.telegroo.telegram.types

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.TypeAnnotations
import tech.teslex.telegroo.telegram.types.input.InputFile

@TypeAnnotations
class InputMediaPhoto extends InputMedia {

	/**
	 * Type of the result, must be photo
	 */
	String type = 'photo'

	/**
	 * File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://<file_attach_name>” to upload a new one using multipart/form-data under <file_attach_name> name. More info on Sending Files »
	 */
	@JsonIgnore
	InputFile media

	/**
	 * Optional. Caption of the photo to be sent, 0-1024 characters
	 */
	@JsonProperty(required = false)
	String caption

	/**
	 * Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
	 */
	@JsonProperty(value = 'parse_mode', required = false)
	String parseMode

}
