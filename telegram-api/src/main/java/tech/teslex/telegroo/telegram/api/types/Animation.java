package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents an animation file (GIF or H.264/MPEG-4 AVC video without sound).
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Animation {

	/**
	 * Unique file identifier
	 */
	@JsonProperty("file_id")
	private String fileId;
	/**
	 * Video width as defined by sender
	 */
	private Integer width;
	/**
	 * Video height as defined by senderx
	 */
	private Integer height;
	/**
	 * Duration of the video in seconds as defined by sender
	 */
	private Integer duration;
	/**
	 * Optional. Animation thumbnail as defined by sender
	 */
	@JsonProperty(required = false)
	private PhotoSize thumb;
	/**
	 * Optional. Original animation filename as defined by sender
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
