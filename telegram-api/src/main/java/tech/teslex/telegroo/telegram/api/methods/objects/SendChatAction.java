package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;
import tech.teslex.telegroo.telegram.enums.ChatAction;

/**
 * sendChatAction
 * Use this method when you need to tell the user that something is happening on the bot's side. The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status). Returns True on success.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendChatAction implements MethodObject {
	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * Type of action to broadcast. Choose one, depending on what the user is about to receive: typing for text messages, upload_photo for photos, record_video or upload_video for videos, record_audio or upload_audio for audio files, upload_document for general files, find_location for location data, record_video_note or upload_video_note for video notes.
	 */
	@JsonProperty(required = true)
	private String action;

	public static SendChatAction create() {
		return new SendChatAction();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "sendChatAction";
	}

	@JsonIgnore
	public void setAction(ChatAction action) {
		this.action = action.getValue();
	}

	public SendChatAction chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public SendChatAction action(String action) {
		this.action = action;
		return this;
	}
}
