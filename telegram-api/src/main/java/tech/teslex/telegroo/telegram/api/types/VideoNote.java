package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoNote {
	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(value = "file_id")
	private String fileId;
	/**
	 * Video width and height (diameter of the video message) as defined by sender
	 */
	private Integer length;
	/**
	 * Duration of the video in seconds as defined by sender
	 */
	private Integer duration;
	/**
	 * Optional. Video thumbnail
	 */
	@JsonProperty(required = false)
	private PhotoSize thumb;
	/**
	 * Optional. File size
	 */
	@JsonProperty(value = "file_size", required = false)
	private Integer fileSize;
}
