package tech.teslex.telegroo.telegram.types.stickers

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.Canonical
import tech.teslex.telegroo.telegram.types.PhotoSize

@Canonical
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class Sticker {

	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(value = 'file_id')
	String fileId

	/**
	 * Sticker width
	 */
	Integer width

	/**
	 * Sticker height
	 */
	Integer height

	/**
	 * Optional. Sticker thumbnail in the .webp or .jpg format
	 */
	@JsonProperty(required = false)
	PhotoSize thumb

	/**
	 * Optional. Emoji associated with the sticker
	 */
	@JsonProperty(required = false)
	String emoji

	/**
	 * Optional. Name of the sticker set to which the sticker belongs
	 */
	@JsonProperty(value = 'set_name', required = false)
	String setName

	/**
	 * Optional. For mask stickers, the position where the mask should be placed
	 */
	@JsonProperty(value = 'mask_position', required = false)
	MaskPosition maskPosition

	/**
	 * Optional. File size
	 */
	@JsonProperty(value = 'file_size', required = false)
	Integer fileSize
}
