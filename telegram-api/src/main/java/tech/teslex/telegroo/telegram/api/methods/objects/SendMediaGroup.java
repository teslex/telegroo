package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObjectWithMedia;
import tech.teslex.telegroo.telegram.api.types.input.InputMedia;

import java.util.List;

/**
 * sendMediaGroup
 * Use this method to send a group of photos or videos as an album. On success, an array of the sent Messages is returned.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendMediaGroup implements MethodObjectWithMedia {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 * <p>
	 * Integer or String
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * A JSON-serialized array describing photos and videos to be sent, must include 2–10 items
	 */
	@JsonIgnore
	private List<InputMedia> media;
	/**
	 * Sends the messages silently. Users will receive a notification with no sound.
	 */
	@JsonProperty(value = "disable_notification", required = false)
	private Boolean disableNotification;
	/**
	 * If the messages are a reply, ID of the original message
	 */
	@JsonProperty(value = "reply_to_message_id", required = false)
	private Integer replyToMessageId;

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "sendMediaGroup";
	}

	public Object getChatId() {
		return chatId;
	}

	@Override
	public List<InputMedia> getMedia() {
		return media;
	}
}
