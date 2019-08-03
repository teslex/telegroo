package tech.teslex.telegroo.telegram.api.methods.objects.games;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * setGameScore
 * Use this method to set the score of the specified user in a game. On success, if the message was sent by the bot, returns the edited Message, otherwise returns True. Returns an error, if the new score is not greater than the user's current score in the chat and force is False.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetGameScore implements MethodObject {

	/**
	 * User identifier
	 */
	@JsonProperty(value = "user_id", required = true)
	private Integer userId;
	/**
	 * New score, must be non-negative
	 */
	@JsonProperty(required = true)
	private Integer score;
	/**
	 * Pass True, if the high score is allowed to decrease. This can be useful when fixing mistakes or banning cheaters
	 */
	@JsonProperty(required = false)
	private Boolean force;
	/**
	 * Pass True, if the game message should not be automatically edited to include the current scoreboard
	 */
	@JsonProperty(value = "disable_edit_message", required = false)
	private Boolean disableEditMessage;
	/**
	 * Required if inline_message_id is not specified. Unique identifier for the target chat
	 */
	@JsonProperty(value = "chat_id", required = false)
	private Integer chatId;
	/**
	 * Required if inline_message_id is not specified. Identifier of the sent message
	 */
	@JsonProperty(value = "message_id", required = false)
	private Integer messageId;
	/**
	 * Required if chat_id and message_id are not specified. Identifier of the inline message
	 */
	@JsonProperty(value = "inline_message_id", required = false)
	private String inlineMessageId;

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "setGameScore";
	}
}
