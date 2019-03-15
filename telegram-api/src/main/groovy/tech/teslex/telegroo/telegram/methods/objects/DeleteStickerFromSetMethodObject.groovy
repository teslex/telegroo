package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.MapConstructor
import groovy.transform.ToString
import groovy.transform.builder.Builder
import tech.teslex.telegroo.telegram.methods.MethodObject

/**
 * deleteStickerFromSet
 * Use this method to delete a sticker from a set created by the bot. Returns True on success.
 */
@ToString
@MapConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@CompileStatic
@Builder
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
