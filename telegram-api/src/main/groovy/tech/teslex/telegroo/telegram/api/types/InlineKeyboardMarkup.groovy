package tech.teslex.telegroo.telegram.api.types


import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.builder.Builder
import tech.teslex.telegroo.telegram.api.TypeAnnotations

@Builder
@TypeAnnotations
class InlineKeyboardMarkup {

	/**
	 * Array of button rows, each represented by an Array of InlineKeyboardButton objects
	 */
	@JsonProperty(value = 'inline_keyboard')
	List<List<InlineKeyboardButton>> inlineKeyboard
}
