package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhotoSize {
	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(value = "file_id")
	private String fileId;
	/**
	 * Photo width
	 */
	private Integer width;
	/**
	 * Photo height
	 */
	private Integer height;
	/**
	 * Optional. File size
	 */
	@JsonProperty(value = "file_size", required = false)
	private Integer fileSize;
}
