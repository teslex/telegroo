package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.MapConstructor
import groovy.transform.ToString
import groovy.transform.builder.Builder
import tech.teslex.telegroo.telegram.methods.MethodObject

/**
 * setStickerPositionInSet
 * Use this method to move a sticker in a set created by the bot to a specific position . Returns True on success.
 */
@ToString
@MapConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@CompileStatic
@Builder
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
	String getPathMethod() {
		'setStickerPositionInSet'
	}
}
