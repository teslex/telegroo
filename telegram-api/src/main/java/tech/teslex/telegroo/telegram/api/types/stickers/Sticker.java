package tech.teslex.telegroo.telegram.api.types.stickers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.types.PhotoSize;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sticker {

	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(value = "file_id")
	private String fileId;
	/**
	 * Sticker width
	 */
	private Integer width;
	/**
	 * Sticker height
	 */
	private Integer height;
	/**
	 * Optional. Sticker thumbnail in the .webp or .jpg format
	 */
	@JsonProperty(required = false)
	private PhotoSize thumb;
	/**
	 * Optional. Emoji associated with the sticker
	 */
	@JsonProperty(required = false)
	private String emoji;
	/**
	 * Optional. Name of the sticker set to which the sticker belongs
	 */
	@JsonProperty(value = "set_name", required = false)
	private String setName;
	/**
	 * Optional. For mask stickers, the position where the mask should be placed
	 */
	@JsonProperty(value = "mask_position", required = false)
	private MaskPosition maskPosition;
	/**
	 * Optional. File size
	 */
	@JsonProperty(value = "file_size", required = false)
	private Integer fileSize;
}
