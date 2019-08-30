package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * sendContact
 * Use this method to send phone contacts. On success, the sent Message is returned.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendContact implements MethodObject {
	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * Contact's phone number
	 */
	@JsonProperty(value = "phone_number", required = true)
	private String phoneNumber;
	/**
	 * Contact's first name
	 */
	@JsonProperty(value = "first_name", required = true)
	private String firstName;
	/**
	 * Contact's last name
	 */
	@JsonProperty(value = "last_name", required = false)
	private String lastName;
	/**
	 * Additional data about the contact in the form of a vCard, 0-2048 bytes
	 */
	@JsonProperty(required = false)
	private String vcard;
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

	public static SendContact create() {
		return new SendContact();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "sendContact";
	}

	public SendContact chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public SendContact phoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public SendContact firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public SendContact lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public SendContact vcard(String vcard) {
		this.vcard = vcard;
		return this;
	}

	public SendContact disableNotification(Boolean disableNotification) {
		this.disableNotification = disableNotification;
		return this;
	}

	public SendContact replyToMessageId(Integer replyToMessageId) {
		this.replyToMessageId = replyToMessageId;
		return this;
	}

	public SendContact replyMarkup(Object replyMarkup) {
		this.replyMarkup = replyMarkup;
		return this;
	}
}
