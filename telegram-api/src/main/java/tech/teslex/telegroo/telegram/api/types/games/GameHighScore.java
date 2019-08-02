package tech.teslex.telegroo.telegram.api.types.games;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.types.User;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameHighScore {
	/**
	 * Position in high score table for the game
	 */
	private Integer position;
	/**
	 * User
	 */
	private User user;
	/**
	 * Score
	 */
	private Integer score;
}
