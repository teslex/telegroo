package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.MapConstructor
import groovy.transform.ToString
import groovy.transform.builder.Builder
import tech.teslex.telegroo.telegram.methods.MethodObject

/**
 * getStickerSet
 * Use this method to get a sticker set. On success, a StickerSet object is returned.
 */
@ToString
@MapConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@CompileStatic
@Builder
class GetStickerSetMethodObject implements MethodObject {

	/**
	 * Name of the sticker set
	 */
	@JsonProperty(required = true)
	String name

	@Override
	String getPathMethod() {
		'getStickerSet'
	}
}
