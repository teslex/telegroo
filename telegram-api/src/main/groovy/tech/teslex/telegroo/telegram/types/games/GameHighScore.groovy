package tech.teslex.telegroo.telegram.types.games

import com.fasterxml.jackson.annotation.JsonInclude
import groovy.transform.Canonical
import groovy.transform.CompileStatic
import groovy.transform.ToString
import tech.teslex.telegroo.telegram.types.User

@Canonical
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
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