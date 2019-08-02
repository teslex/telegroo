package tech.teslex.telegroo.telegram.api.methods.objects.polls;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup;

/**
 * stopPoll
 * Use this method to stop a poll which was sent by the bot. On success, the stopped Poll with the final results is returned.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StopPollMethodObject implements MethodObject {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * Identifier of the original message with the poll
	 */
	@JsonProperty(value = "message_id")
	private Integer messageId;
	/**
	 * A JSON-serialized object for a new message inline keyboard.
	 */
	@JsonProperty(value = "reply_markup", required = false)
	private InlineKeyboardMarkup replyMarkup;

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "stopPoll";
	}
}
