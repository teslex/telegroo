package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Document {
	/**
	 * Unique file identifier
	 */
	@JsonProperty(value = "file_id")
	private String fileId;
	/**
	 * Optional. Document thumbnail as defined by sender
	 */
	@JsonProperty(required = false)
	private PhotoSize thumb;
	/**
	 * Optional. Original filename as defined by sender
	 */
	@JsonProperty(value = "file_name", required = false)
	private String fileName;
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
