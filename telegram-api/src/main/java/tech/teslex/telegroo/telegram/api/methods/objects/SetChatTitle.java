package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * setChatTitle
 * Use this method to change the title of a chat. Titles can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns True on success.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetChatTitle implements MethodObject {
	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * New chat title, 1-255 characters
	 */
	@JsonProperty(required = true)
	private String title;

	public static SetChatTitle create() {
		return new SetChatTitle();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "setChatTitle";
	}

	public SetChatTitle chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public SetChatTitle title(String title) {
		this.title = title;
		return this;
	}
}
