package tech.teslex.telegroo.telegram.types.games

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.ToString
import tech.teslex.telegroo.telegram.types.Animation
import tech.teslex.telegroo.telegram.types.MessageEntity
import tech.teslex.telegroo.telegram.types.PhotoSize

@ToString
@CompileStatic
class Game {

	/**
	 * Title of the game
	 */
	String title

	/**
	 * Description of the game
	 */
	String description

	/**
	 * Photo that will be displayed in the game message in chats.
	 */
	List<PhotoSize> photo

	/**
	 * Optional. Brief description of the game or high scores included in the game message. Can be automatically edited to include current high scores for the game when the bot calls setGameScore, or manually edited using editMessageText. 0-4096 characters.
	 */
	@JsonProperty(required = false)
	String text

	/**
	 * Optional. Special entities that appear in text, such as usernames, URLs, bot commands, etc.
	 */
	@JsonProperty(value = 'text_entities', required = false)
	List<MessageEntity> textEntities

	/**
	 * Optional. Animation that will be displayed in the game message in chats. Upload via BotFather
	 */
	@JsonProperty(required = false)
	Animation animation
}