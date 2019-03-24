package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.methods.MethodObjectAnnotations

/**
 * deleteStickerFromSet
 * Use this method to delete a sticker from a set created by the bot. Returns True on success.
 */
@MethodObjectAnnotations
class DeleteStickerFromSetMethodObject implements MethodObject {

	/**
	 * File identifier of the sticker
	 */
	@JsonProperty(required = true)
	String sticker

	@Override
	@JsonIgnore
	String getPathMethod() {
		'deleteStickerFromSet'
	}
}
