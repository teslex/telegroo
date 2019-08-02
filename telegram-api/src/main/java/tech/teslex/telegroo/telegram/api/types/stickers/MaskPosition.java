package tech.teslex.telegroo.telegram.api.types.stickers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MaskPosition {

	/**
	 * The part of the face relative to which the mask should be placed. One of “forehead”, “eyes”, “mouth”, or “chin”.
	 */
	private String point;
	/**
	 * Shift by X-axis measured in widths of the mask scaled to the face size, from left to right. For example, choosing -1.0 will place mask just to the left of the default mask position.
	 */
	@JsonProperty(value = "x_shift")
	private Float xShift;
	/**
	 * Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom. For example, 1.0 will place the mask just below the default mask position.
	 */
	@JsonProperty(value = "y_shift")
	private Float yShift;
	/**
	 * Mask scaling coefficient. For example, 2.0 means double size.
	 */
	private Float scale;
}
