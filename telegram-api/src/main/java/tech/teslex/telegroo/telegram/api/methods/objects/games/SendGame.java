package tech.teslex.telegroo.telegram.api.methods.objects.games;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup;

/**
 * sendGame
 * Use this method to send a game. On success, the sent Message is returned.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendGame implements MethodObject {
	/**
	 * Unique identifier for the target chat
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * Short name of the game, serves as the unique identifier for the game. Set up your games via Botfather.
	 */
	@JsonProperty(value = "game_short_name", required = true)
	private String gameShortName;
	/**
	 * Sends the message silently. Users will receive a notification with no sound.
	 */
	@JsonProperty(value = "disable_notification", required = false)
	private Boolean disableNotification;
	/**
	 * If the message is a reply, ID of the original message
	 */
	@JsonProperty(value = "reply_to_message_id", required = false)
	private Integer replyToMessageId;
	/**
	 * A JSON-serialized object for an inline keyboard. If empty, one ‘Play game_title’ button will be shown. If not empty, the first button must launch the game.
	 */
	@JsonProperty(value = "reply_markup", required = false)
	private InlineKeyboardMarkup replyMarkup;

	public static SendGame create() {
		return new SendGame();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "sendGame";
	}

	public SendGame chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public SendGame gameShortName(String gameShortName) {
		this.gameShortName = gameShortName;
		return this;
	}

	public SendGame disableNotification(Boolean disableNotification) {
		this.disableNotification = disableNotification;
		return this;
	}

	public SendGame replyToMessageId(Integer replyToMessageId) {
		this.replyToMessageId = replyToMessageId;
		return this;
	}

	public SendGame replyMarkup(InlineKeyboardMarkup replyMarkup) {
		this.replyMarkup = replyMarkup;
		return this;
	}
}
