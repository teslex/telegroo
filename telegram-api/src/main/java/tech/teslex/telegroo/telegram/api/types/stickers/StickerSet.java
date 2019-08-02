package tech.teslex.telegroo.telegram.api.types.stickers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StickerSet {

	/**
	 * Sticker set name
	 */
	private String name;
	/**
	 * Sticker set title
	 */
	private String title;
	/**
	 * True, if the sticker set contains masks
	 */
	@JsonProperty(value = "contains_masks")
	private Boolean containsMasks;
	/**
	 * List of all set stickers
	 */
	private List<Sticker> stickers;
}
