package tech.teslex.telegroo.telegram.api.types.stickers


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.api.TypeAnnotations

@TypeAnnotations
class StickerSet {

	/**
	 * Sticker set name
	 */
	String name

	/**
	 * Sticker set title
	 */
	String title

	/**
	 * True, if the sticker set contains masks
	 */
	@JsonProperty(value = 'contains_masks')
	Boolean containsMasks

	/**
	 * List of all set stickers
	 */
	List<Sticker> stickers
}
