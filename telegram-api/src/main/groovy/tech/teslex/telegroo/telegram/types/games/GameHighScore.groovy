package tech.teslex.telegroo.telegram.types.games


import tech.teslex.telegroo.telegram.TypeAnnotations
import tech.teslex.telegroo.telegram.types.User

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