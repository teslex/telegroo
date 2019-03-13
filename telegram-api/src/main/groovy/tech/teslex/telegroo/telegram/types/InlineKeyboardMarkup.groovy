package tech.teslex.telegroo.telegram.types

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
class InlineKeyboardMarkup {

	/**
	 * Array of button rows, each represented by an Array of InlineKeyboardButton objects
	 */
	@JsonProperty(value = 'inline_keyboard')
	List<List<InlineKeyboardButton>> inlineKeyboard
}