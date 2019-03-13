package tech.teslex.telegroo.telegram.types.stickers

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
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
