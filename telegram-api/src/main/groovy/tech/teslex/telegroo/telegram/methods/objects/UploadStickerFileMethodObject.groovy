package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.methods.MethodObjectAnnotations
import tech.teslex.telegroo.telegram.attach.InputFile

/**
 * uploadStickerFile
 * Use this method to upload a .png file with a sticker for later use in createNewStickerSet and addStickerToSet methods (can be used multiple times). Returns the uploaded File on success.
 */
@MethodObjectAnnotations
class UploadStickerFileMethodObject implements MethodObject {

	/**
	 * User identifier of sticker file owner
	 */
	@JsonProperty(value = 'user_id', required = true)
	Integer userId

	/**
	 * Png image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. More info on Sending Files »
	 */
	@JsonProperty(value = 'png_sticker', required = true)
	InputFile pngSticker

	@Override
	@JsonIgnore
	String getPathMethod() {
		'uploadStickerFile'
	}
}
