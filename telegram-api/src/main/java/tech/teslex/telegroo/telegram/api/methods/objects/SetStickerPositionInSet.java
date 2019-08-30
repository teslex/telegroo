package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * setStickerPositionInSet
 * Use this method to move a sticker in a set created by the bot to a specific position . Returns True on success.
 */
@NoArgsConstructor
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

	public static SetStickerPositionInSet create() {
		return new SetStickerPositionInSet();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "setStickerPositionInSet";
	}

	public SetStickerPositionInSet sticker(String sticker) {
		this.sticker = sticker;
		return this;
	}

	public SetStickerPositionInSet position(Integer position) {
		this.position = position;
		return this;
	}
}
