package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;
import tech.teslex.telegroo.telegram.attach.InputFile;

/**
 * uploadStickerFile
 * Use this method to upload a .png file with a sticker for later use in createNewStickerSet and addStickerToSet methods (can be used multiple times). Returns the uploaded File on success.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UploadStickerFile implements MethodObject {
	/**
	 * User identifier of sticker file owner
	 */
	@JsonProperty(value = "user_id", required = true)
	private Integer userId;
	/**
	 * Png image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. More info on Sending Files »
	 */
	@JsonProperty(value = "png_sticker", required = true)
	private InputFile pngSticker;

	public static UploadStickerFile create() {
		return new UploadStickerFile();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "uploadStickerFile";
	}

	public UploadStickerFile userId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public UploadStickerFile pngSticker(InputFile pngSticker) {
		this.pngSticker = pngSticker;
		return this;
	}
}
