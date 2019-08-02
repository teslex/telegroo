package tech.teslex.telegroo.telegram.api.methods.objects.games;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup;

/**
 * sendGame
 * Use this method to send a game. On success, the sent Message is returned.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendGameMethodObject implements MethodObject {

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

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "sendGame";
	}
}
