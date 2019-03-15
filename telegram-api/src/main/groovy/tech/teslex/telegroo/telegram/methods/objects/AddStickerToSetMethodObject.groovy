package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.MapConstructor
import groovy.transform.ToString
import groovy.transform.builder.Builder
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.types.InputFile
import tech.teslex.telegroo.telegram.types.stickers.MaskPosition

/**
 * addStickerToSet
 * Use this method to add a new sticker to a set created by the bot. Returns True on success.
 */
@ToString
@MapConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@CompileStatic
@Builder
class AddStickerToSetMethodObject implements MethodObject {

	/**
	 * User identifier of sticker set owner
	 */
	@JsonProperty(value = 'user_id', required = true)
	Integer userId

	/**
	 * Sticker set name
	 */
	@JsonProperty(required = true)
	String name

	/**
	 * Png image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. Pass a file_id as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. More info on Sending Files »
	 */
	@JsonProperty(value = 'png_sticker', required = true)
	InputFile pngSticker

	/**
	 * One or more emoji corresponding to the sticker
	 */
	@JsonProperty(required = true)
	String emojis

	/**
	 * A JSON-serialized object for position where the mask should be placed on faces
	 */
	@JsonProperty(value = 'mask_position', required = false)
	MaskPosition maskPosition

	@Override
	@JsonIgnore
	String getPathMethod() {
		'addStickerToSet'
	}
}
