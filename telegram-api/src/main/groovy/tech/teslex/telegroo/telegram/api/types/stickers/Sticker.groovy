package tech.teslex.telegroo.telegram.api.types.stickers


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.api.TypeAnnotations
import tech.teslex.telegroo.telegram.api.types.PhotoSize

@TypeAnnotations
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
