package tech.teslex.telegroo.telegram.api.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.api.methods.MethodObject
import tech.teslex.telegroo.telegram.api.methods.MethodObjectAnnotations
import tech.teslex.telegroo.telegram.attach.InputFile
import tech.teslex.telegroo.telegram.api.types.stickers.MaskPosition

/**
 * createNewStickerSet
 * Use this method to create new sticker set owned by a user. The bot will be able to edit the created sticker set. Returns True on success.
 */
@MethodObjectAnnotations
class CreateNewStickerSetMethodObject implements MethodObject {

	/**
	 * User identifier of created sticker set owner
	 */
	@JsonProperty(value = 'user_id', required = true)
	Integer userId

	/**
	 * Short name of sticker set, to be used in t.me/addstickers/ URLs (e.g., animals). Can contain only english letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores and must end in “_by_<bot username>”. <bot_username> is case insensitive. 1-64 characters.
	 */
	@JsonProperty(required = true)
	String name

	/**
	 * Sticker set title, 1-64 characters
	 */
	@JsonProperty(required = true)
	String title

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
	 * Pass True, if a set of mask stickers should be created
	 */
	@JsonProperty(value = 'contains_masks', required = false)
	Boolean containsMasks

	/**
	 * A JSON-serialized object for position where the mask should be placed on faces
	 */
	@JsonProperty(value = 'mask_position', required = false)
	MaskPosition maskPosition

	@Override
	@JsonIgnore
	String getPathMethod() {
		'createNewStickerSet'
	}
}
