package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Voice {
	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(value = "file_id")
	private String fileId;
	/**
	 * Duration of the audio in seconds as defined by sender
	 */
	private Integer duration;
	/**
	 * Optional. MIME value of the file as defined by sender
	 */
	@JsonProperty(value = "mime_type", required = false)
	private String mimeType;
	/**
	 * Optional. File size
	 */
	@JsonProperty(value = "file_size", required = false)
	private Integer fileSize;
}
