package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup;

/**
 * editMessageReplyMarkup
 * Use this method to edit only the reply markup of messages sent by the bot or via the bot (for inline bots). On success, if edited message is sent by the bot, the edited Message is returned, otherwise True is returned.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EditMessageReplyMarkupMethodObject implements MethodObject {

	/**
	 * Required if inline_message_id is not specified. Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = false)
	private Object chatId;
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
	/**
	 * A JSON-serialized object for an inline keyboard.
	 */
	@JsonProperty(value = "reply_markup", required = false)
	private InlineKeyboardMarkup replyMarkup;

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "editMessageReplyMarkup";
	}
}
