package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents the contents of a file to be uploaded. Must be posted using multipart/form-data in the usual way that files are uploaded via the browser.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileObject {
	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(value = "file_id")
	private String fileId;
	/**
	 * Optional. File size, if known
	 */
	@JsonProperty(value = "file_size", required = false)
	private Integer fileSize;
	/**
	 * Optional. File path. Use https://api.telegram.org/file/bot<token>/<file_path> to get the file.
	 */
	@JsonProperty(value = "file_path", required = false)
	private String filePath;
}
