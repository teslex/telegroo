package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObjectWithFile;
import tech.teslex.telegroo.telegram.attach.InputFile;

/**
 * setChatPhoto
 * Use this method to set a new profile photo for the chat. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns True on success.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetChatPhoto implements MethodObjectWithFile {
	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	@JsonIgnore
	private InputFile photo;

	public static SetChatPhoto create() {
		return new SetChatPhoto();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "setChatPhoto";
	}

	@Override
	@JsonIgnore
	public InputFile getInputFile() {
		return this.photo;
	}

	public SetChatPhoto chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public SetChatPhoto photo(InputFile photo) {
		this.photo = photo;
		return this;
	}
}
