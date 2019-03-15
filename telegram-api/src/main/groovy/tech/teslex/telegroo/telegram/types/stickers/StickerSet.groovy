package tech.teslex.telegroo.telegram.types.stickers

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.Canonical

@Canonical
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
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
