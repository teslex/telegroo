package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * forwardMessage
 * Use this method to forward messages of any kind. On success, the sent Message is returned.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ForwardMessage implements MethodObject {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 * <p>
	 * Integer or String
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * Unique identifier for the chat where the original message was sent (or channel username in the format @channelusername)
	 * <p>
	 * Integer or String
	 */
	@JsonProperty(value = "from_chat_id", required = true)
	private Object fromChatId;
	/**
	 * Sends the message silently. Users will receive a notification with no sound.
	 */
	@JsonProperty(value = "disable_notification", required = false)
	private Boolean disableNotification;
	/**
	 * Message identifier in the chat specified in from_chat_id
	 */
	@JsonProperty(value = "message_id", required = true)
	private Integer messageId;

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "forwardMessage";
	}
}
