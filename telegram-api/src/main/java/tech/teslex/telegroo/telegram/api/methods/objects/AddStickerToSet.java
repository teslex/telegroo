package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;
import tech.teslex.telegroo.telegram.api.types.stickers.MaskPosition;
import tech.teslex.telegroo.telegram.attach.InputFile;

/**
 * addStickerToSet
 * Use this method to add a new sticker to a set created by the bot. Returns True on success.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddStickerToSet implements MethodObject {
	/**
	 * User identifier of sticker set owner
	 */
	@JsonProperty(value = "user_id", required = true)
	private Integer userId;
	/**
	 * Sticker set name
	 */
	@JsonProperty(required = true)
	private String name;
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
	 * A JSON-serialized object for position where the mask should be placed on faces
	 */
	@JsonProperty(value = "mask_position", required = false)
	private MaskPosition maskPosition;

	public static AddStickerToSet create() {
		return new AddStickerToSet();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "addStickerToSet";
	}

	public AddStickerToSet userId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public AddStickerToSet name(String name) {
		this.name = name;
		return this;
	}

	public AddStickerToSet pngSticker(InputFile pngSticker) {
		this.pngSticker = pngSticker;
		return this;
	}

	public AddStickerToSet emojis(String emojis) {
		this.emojis = emojis;
		return this;
	}

	public AddStickerToSet maskPosition(MaskPosition maskPosition) {
		this.maskPosition = maskPosition;
		return this;
	}
}
