package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * setStickerPositionInSet
 * Use this method to move a sticker in a set created by the bot to a specific position . Returns True on success.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetStickerPositionInSet implements MethodObject {

	/**
	 * File identifier of the sticker
	 */
	@JsonProperty(required = true)
	private String sticker;

	/**
	 * New sticker position in the set, zero-based
	 */
	@JsonProperty(required = true)
	private Integer position;

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "setStickerPositionInSet";
	}
}
