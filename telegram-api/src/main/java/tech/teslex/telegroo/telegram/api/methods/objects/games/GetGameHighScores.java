package tech.teslex.telegroo.telegram.api.methods.objects.games;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * getGameHighScores
 * Use this method to get data for high score tables. Will return the score of the specified user and several of his neighbors in a game. On success, returns an Array of GameHighScore objects.
 * <p>
 * This method will currently return scores for the target user, plus two of his closest neighbors on each side. Will also return the top three users if the user and his neighbors are not among them. Please note that this behavior is subject to change.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetGameHighScores implements MethodObject {
	/**
	 * Target user id
	 */
	@JsonProperty(value = "user_id", required = true)
	private Integer userId;
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

	public static GetGameHighScores create() {
		return new GetGameHighScores();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "getGameHighScores";
	}

	public GetGameHighScores userId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public GetGameHighScores chatId(Integer chatId) {
		this.chatId = chatId;
		return this;
	}

	public GetGameHighScores messageId(Integer messageId) {
		this.messageId = messageId;
		return this;
	}

	public GetGameHighScores inlineMessageId(String inlineMessageId) {
		this.inlineMessageId = inlineMessageId;
		return this;
	}
}
