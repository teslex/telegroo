package tech.teslex.telegroo.telegram.api.methods.objects.polls;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

import java.util.List;

/**
 * sendPoll
 * Use this method to send a native poll. A native poll can't be sent to a private chat. On success, the sent Message is returned.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendPoll implements MethodObject {
	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * Poll question, 1-255 characters
	 */
	@JsonProperty(required = true)
	private String question;
	/**
	 * List of answer options, 2-10 strings 1-100 characters each
	 */
	@JsonProperty(required = true)
	private List<String> options;
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
	 * Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
	 * <p>
	 * InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply
	 */
	@JsonProperty(value = "reply_markup", required = false)
	private Object replyMarkup;

	public static SendPoll create() {
		return new SendPoll();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "sendPoll";
	}

	public SendPoll chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public SendPoll question(String question) {
		this.question = question;
		return this;
	}

	public SendPoll options(List<String> options) {
		this.options = options;
		return this;
	}

	public SendPoll disableNotification(Boolean disableNotification) {
		this.disableNotification = disableNotification;
		return this;
	}

	public SendPoll replyToMessageId(Integer replyToMessageId) {
		this.replyToMessageId = replyToMessageId;
		return this;
	}

	public SendPoll replyMarkup(Object replyMarkup) {
		this.replyMarkup = replyMarkup;
		return this;
	}
}
