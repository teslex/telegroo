package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;
import tech.teslex.telegroo.telegram.api.types.stickers.MaskPosition;
import tech.teslex.telegroo.telegram.attach.InputFile;

/**
 * createNewStickerSet
 * Use this method to create new sticker set owned by a user. The bot will be able to edit the created sticker set. Returns True on success.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateNewStickerSetMethodObject implements MethodObject {
	/**
	 * User identifier of created sticker set owner
	 */
	@JsonProperty(value = "user_id", required = true)
	private Integer userId;
	/**
	 * Short name of sticker set, to be used in t.me/addstickers/ URLs (e.g., animals). Can contain only english letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores and must end in “_by_<bot username>”. <bot_username> is case insensitive. 1-64 characters.
	 */
	@JsonProperty(required = true)
	private String name;
	/**
	 * Sticker set title, 1-64 characters
	 */
	@JsonProperty(required = true)
	private String title;
	/**
	 * Png image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. Pass a file_id as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. More info on Sending Files »
	 */
	@JsonProperty(value = "png_sticker", required = true)
	private InputFile pngSticker;
	/**
	 * One or more emoji corresponding to the sticker
	 */
	@JsonProperty(required = true)
	private String emojis;
	/**
	 * Pass True, if a set of mask stickers should be created
	 */
	@JsonProperty(value = "contains_masks", required = false)
	private Boolean containsMasks;
	/**
	 * A JSON-serialized object for position where the mask should be placed on faces
	 */
	@JsonProperty(value = "mask_position", required = false)
	private MaskPosition maskPosition;

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "createNewStickerSet";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public InputFile getPngSticker() {
		return pngSticker;
	}

	public void setPngSticker(InputFile pngSticker) {
		this.pngSticker = pngSticker;
	}

	public String getEmojis() {
		return emojis;
	}

	public void setEmojis(String emojis) {
		this.emojis = emojis;
	}

	public Boolean getContainsMasks() {
		return containsMasks;
	}

	public void setContainsMasks(Boolean containsMasks) {
		this.containsMasks = containsMasks;
	}

	public MaskPosition getMaskPosition() {
		return maskPosition;
	}

	public void setMaskPosition(MaskPosition maskPosition) {
		this.maskPosition = maskPosition;
	}
}
