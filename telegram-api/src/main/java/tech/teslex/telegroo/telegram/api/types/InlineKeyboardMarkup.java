package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InlineKeyboardMarkup {
	/**
	 * Array of button rows, each represented by an Array of InlineKeyboardButton objects
	 */
	@JsonProperty(value = "inline_keyboard")
	private List<List<InlineKeyboardButton>> inlineKeyboard;
}
