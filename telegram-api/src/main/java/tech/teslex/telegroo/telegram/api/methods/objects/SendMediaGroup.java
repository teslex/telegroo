package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObjectWithDefaultParams;
import tech.teslex.telegroo.telegram.api.methods.MethodObjectWithMedia;
import tech.teslex.telegroo.telegram.api.types.input.InputMedia;
import tech.teslex.telegroo.telegram.api.types.update.Update;

import java.util.List;
import java.util.Objects;

/**
 * sendMediaGroup
 * Use this method to send a group of photos or videos as an album. On success, an array of the sent Messages is returned.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendMediaGroup implements MethodObjectWithMedia, MethodObjectWithDefaultParams {
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

	public static SendMediaGroup create() {
		return new SendMediaGroup();
	}

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

	public SendMediaGroup chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public SendMediaGroup media(List<InputMedia> media) {
		this.media = media;
		return this;
	}

	public SendMediaGroup disableNotification(Boolean disableNotification) {
		this.disableNotification = disableNotification;
		return this;
	}

	public SendMediaGroup replyToMessageId(Integer replyToMessageId) {
		this.replyToMessageId = replyToMessageId;
		return this;
	}

	@Override
	public void useDefault(Update update) {
		Objects.requireNonNull(update);
		Objects.requireNonNull(update.getMessage());
		Objects.requireNonNull(update.getMessage().getChat());
		Objects.requireNonNull(update.getMessage().getChat().getId());

		if (this.getChatId() == null)
			this.setChatId(update.getMessage().getChat().getId());
	}
}
