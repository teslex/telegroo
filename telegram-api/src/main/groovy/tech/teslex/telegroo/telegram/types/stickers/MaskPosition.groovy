package tech.teslex.telegroo.telegram.types.stickers


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.TypeAnnotations

@TypeAnnotations
class MaskPosition {

	/**
	 * The part of the face relative to which the mask should be placed. One of “forehead”, “eyes”, “mouth”, or “chin”.
	 */
	String point

	/**
	 * Shift by X-axis measured in widths of the mask scaled to the face size, from left to right. For example, choosing -1.0 will place mask just to the left of the default mask position.
	 */
	@JsonProperty(value = 'x_shift')
	Float xShift

	/**
	 * Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom. For example, 1.0 will place the mask just below the default mask position.
	 */
	@JsonProperty(value = 'y_shift')
	Float yShift

	/**
	 * Mask scaling coefficient. For example, 2.0 means double size.
	 */
	Float scale
}
