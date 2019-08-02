package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatPhoto {
	/**
	 * Unique file identifier of small (160x160) chat photo. This file_id can be used only for photo download.
	 */
	@JsonProperty(value = "small_file_id")
	private String smallFileId;
	/**
	 * Unique file identifier of big (640x640) chat photo. This file_id can be used only for photo download.
	 */
	@JsonProperty(value = "big_file_id")
	private String bigFileId;
}
