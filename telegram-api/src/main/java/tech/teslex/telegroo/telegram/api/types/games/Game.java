package tech.teslex.telegroo.telegram.api.types.games;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.types.Animation;
import tech.teslex.telegroo.telegram.api.types.MessageEntity;
import tech.teslex.telegroo.telegram.api.types.PhotoSize;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Game {
	/**
	 * Title of the game
	 */
	private String title;
	/**
	 * Description of the game
	 */
	private String description;
	/**
	 * Photo that will be displayed in the game message in chats.
	 */
	private List<PhotoSize> photo;
	/**
	 * Optional. Brief description of the game or high scores included in the game message. Can be automatically edited to include current high scores for the game when the bot calls setGameScore, or manually edited using editMessageText. 0-4096 characters.
	 */
	@JsonProperty(required = false)
	private String text;
	/**
	 * Optional. Special entities that appear in text, such as usernames, URLs, bot commands, etc.
	 */
	@JsonProperty(value = "text_entities", required = false)
	private List<MessageEntity> textEntities;
	/**
	 * Optional. Animation that will be displayed in the game message in chats. Upload via BotFather
	 */
	@JsonProperty(required = false)
	private Animation animation;
}
