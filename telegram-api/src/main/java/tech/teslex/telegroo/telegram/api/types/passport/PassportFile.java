package tech.teslex.telegroo.telegram.api.types.passport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PassportFile {

	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(value = "file_id")
	private String fileId;
	/**
	 * File size
	 */
	@JsonProperty(value = "file_size")
	private Integer fileSize;
	/**
	 * Unix time when the file was uploaded
	 */
	@JsonProperty(value = "file_date")
	private Integer fileDate;
}
