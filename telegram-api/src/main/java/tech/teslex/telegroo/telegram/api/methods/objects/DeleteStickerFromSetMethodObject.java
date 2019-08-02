package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * deleteStickerFromSet
 * Use this method to delete a sticker from a set created by the bot. Returns True on success.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeleteStickerFromSetMethodObject implements MethodObject {
	/**
	 * File identifier of the sticker
	 */
	@JsonProperty(required = true)
	private String sticker;

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "deleteStickerFromSet";
	}
}
