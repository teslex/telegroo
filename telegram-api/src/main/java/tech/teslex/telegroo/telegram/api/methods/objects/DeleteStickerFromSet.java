package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * deleteStickerFromSet
 * Use this method to delete a sticker from a set created by the bot. Returns True on success.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeleteStickerFromSet implements MethodObject {
	/**
	 * File identifier of the sticker
	 */
	@JsonProperty(required = true)
	private String sticker;

	public static DeleteStickerFromSet create() {
		return new DeleteStickerFromSet();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "deleteStickerFromSet";
	}

	public DeleteStickerFromSet sticker(String sticker) {
		this.sticker = sticker;
		return this;
	}
}
