package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * getStickerSet
 * Use this method to get a sticker set. On success, a StickerSet object is returned.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetStickerSet implements MethodObject {

	/**
	 * Name of the sticker set
	 */
	@JsonProperty(required = true)
	private String name;

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "getStickerSet";
	}
}
