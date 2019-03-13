package tech.teslex.telegroo.telegram.types.games

import groovy.transform.CompileStatic
import groovy.transform.ToString
import tech.teslex.telegroo.telegram.types.User

@ToString
@CompileStatic
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