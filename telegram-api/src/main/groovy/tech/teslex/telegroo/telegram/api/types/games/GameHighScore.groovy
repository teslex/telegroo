package tech.teslex.telegroo.telegram.api.types.games


import tech.teslex.telegroo.telegram.api.TypeAnnotations
import tech.teslex.telegroo.telegram.api.types.User

@TypeAnnotations
class GameHighScore {

	/**
	 * Position in high score table for the game
	 */
	Integer position

	/**
	 * User
	 */
	User user

	/**
	 * Score
	 */
	Integer score
}