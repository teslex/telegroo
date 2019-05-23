package tech.teslex.telegroo.telegram.api.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.api.methods.MethodObject
import tech.teslex.telegroo.telegram.api.methods.MethodObjectAnnotations

/**
 * setStickerPositionInSet
 * Use this method to move a sticker in a set created by the bot to a specific position . Returns True on success.
 */
@MethodObjectAnnotations
class SetStickerPositionInSetMethodObject implements MethodObject {

	/**
	 * File identifier of the sticker
	 */
	@JsonProperty(required = true)
	String sticker

	/**
	 * New sticker position in the set, zero-based
	 */
	@JsonProperty(required = true)
	Integer position

	@Override
	@JsonIgnore
	String getPathMethod() {
		'setStickerPositionInSet'
	}
}
