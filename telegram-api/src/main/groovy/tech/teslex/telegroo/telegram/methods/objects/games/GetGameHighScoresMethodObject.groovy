package tech.teslex.telegroo.telegram.methods.objects.games

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.methods.MethodObjectAnnotations

/**
 * getGameHighScores
 * Use this method to get data for high score tables. Will return the score of the specified user and several of his neighbors in a game. On success, returns an Array of GameHighScore objects.
 *
 * This method will currently return scores for the target user, plus two of his closest neighbors on each side. Will also return the top three users if the user and his neighbors are not among them. Please note that this behavior is subject to change.
 */
@MethodObjectAnnotations
class GetGameHighScoresMethodObject implements MethodObject {

	/**
	 * Target user id
	 */
	@JsonProperty(value = 'user_id', required = true)
	Integer userId

	/**
	 * Required if inline_message_id is not specified. Unique identifier for the target chat
	 */
	@JsonProperty(value = 'chat_id', required = false)
	Integer chatId

	/**
	 * Required if inline_message_id is not specified. Identifier of the sent message
	 */
	@JsonProperty(value = 'message_id', required = false)
	Integer messageId

	/**
	 * Required if chat_id and message_id are not specified. Identifier of the inline message
	 */
	@JsonProperty(value = 'inline_message_id', required = false)
	String inlineMessageId

	@Override
	@JsonIgnore
	String getPathMethod() {
		'getGameHighScores'
	}
}
