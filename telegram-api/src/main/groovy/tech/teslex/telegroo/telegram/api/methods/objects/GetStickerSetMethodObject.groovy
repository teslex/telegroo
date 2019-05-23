package tech.teslex.telegroo.telegram.api.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.api.methods.MethodObject
import tech.teslex.telegroo.telegram.api.methods.MethodObjectAnnotations

/**
 * getStickerSet
 * Use this method to get a sticker set. On success, a StickerSet object is returned.
 */
@MethodObjectAnnotations
class GetStickerSetMethodObject implements MethodObject {

	/**
	 * Name of the sticker set
	 */
	@JsonProperty(required = true)
	String name

	@Override
	@JsonIgnore
	String getPathMethod() {
		'getStickerSet'
	}
}
