package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * stopMessageLiveLocation
 * Use this method to stop updating a live location message sent by the bot or via the bot (for inline bots) before live_period expires. On success, if the message was sent by the bot, the sent Message is returned, otherwise True is returned.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StopMessageLiveLocation implements MethodObject {
	/**
	 * Required if inline_message_id is not specified. Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * Required if inline_message_id is not specified. Identifier of the sent message
	 */
	@JsonProperty(value = "message_id\t", required = false)
	private String messageId;
	/**
	 * Required if chat_id and message_id are not specified. Identifier of the inline message
	 */
	@JsonProperty(value = "inline_message_id", required = false)
	private String inlineMessageId;
	/**
	 * A JSON-serialized object for a new inline keyboard.
	 * <p>
	 * InlineKeyboardMarkup
	 */
	@JsonProperty(value = "reply_markup", required = false)
	private Object replyMarkup;

	public static StopMessageLiveLocation create() {
		return new StopMessageLiveLocation();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "stopMessageLiveLocation";
	}

	public Object getChatId() {
		return chatId;
	}

	public void setChatId(Object chatId) {
		this.chatId = chatId;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getInlineMessageId() {
		return inlineMessageId;
	}

	public void setInlineMessageId(String inlineMessageId) {
		this.inlineMessageId = inlineMessageId;
	}

	public Object getReplyMarkup() {
		return replyMarkup;
	}

	public void setReplyMarkup(Object replyMarkup) {
		this.replyMarkup = replyMarkup;
	}

	public StopMessageLiveLocation chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public StopMessageLiveLocation messageId(String messageId) {
		this.messageId = messageId;
		return this;
	}

	public StopMessageLiveLocation inlineMessageId(String inlineMessageId) {
		this.inlineMessageId = inlineMessageId;
		return this;
	}

	public StopMessageLiveLocation replyMarkup(Object replyMarkup) {
		this.replyMarkup = replyMarkup;
		return this;
	}
}
