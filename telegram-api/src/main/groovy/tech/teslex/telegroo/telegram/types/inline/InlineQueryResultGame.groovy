package tech.teslex.telegroo.telegram.types.inline


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.TypeAnnotations
import tech.teslex.telegroo.telegram.types.InlineKeyboardMarkup

/**
 * Represents a Game.
 */
@TypeAnnotations
class InlineQueryResultGame extends InlineQueryResult {

	/**
	 * Type of the result, must be game
	 */
	String type

	/**
	 * Unique identifier for this result, 1-64 bytes
	 */
	String id

	/**
	 * Short name of the game
	 */
	@JsonProperty(value = 'game_short_name')
	String gameShortName

	/**
	 * Optional. Inline keyboard attached to the message
	 */
	@JsonProperty(value = 'reply_markup', required = false)
	InlineKeyboardMarkup replyMarkup
}
