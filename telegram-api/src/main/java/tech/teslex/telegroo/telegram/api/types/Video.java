package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Video {
	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(value = "file_id")
	private String fileId;
	/**
	 * Video width as defined by sender
	 */
	private Integer width;
	/**
	 * Video height as defined by sender
	 */
	private Integer height;
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
	 * Optional. Mime value of a file as defined by sender
	 */
	@JsonProperty(value = "mime_type", required = false)
	private String mimeType;
	/**
	 * Optional. File size
	 */
	@JsonProperty(value = "file_size", required = false)
	private Integer fileSize;
}
