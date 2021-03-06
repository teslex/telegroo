package tech.teslex.telegroo.telegram.api.types.input;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import tech.teslex.telegroo.telegram.attach.InputFile;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InputMedia {
	/**
	 * File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://<file_attach_name>” to upload a new one using multipart/form-data under <file_attach_name> name. More info on Sending Files »
	 */
	@JsonIgnore
	private InputFile media;
}
