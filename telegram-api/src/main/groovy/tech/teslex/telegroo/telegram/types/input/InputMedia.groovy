package tech.teslex.telegroo.telegram.types.input

import com.fasterxml.jackson.annotation.JsonIgnore
import tech.teslex.telegroo.telegram.TypeAnnotations
import tech.teslex.telegroo.telegram.attach.InputFile

@TypeAnnotations
class InputMedia {

	/**
	 * File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://<file_attach_name>” to upload a new one using multipart/form-data under <file_attach_name> name. More info on Sending Files »
	 */
	@JsonIgnore
	InputFile media
}