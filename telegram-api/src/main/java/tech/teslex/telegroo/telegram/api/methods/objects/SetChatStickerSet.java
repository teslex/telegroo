package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * setChatDescription
 * Use this method to change the description of a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns True on success.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetChatStickerSet implements MethodObject {
	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * New chat description, 1-255 characters
	 */
	@JsonProperty(required = true)
	private String description;

	public static SetChatStickerSet create() {
		return new SetChatStickerSet();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "setChatDescription";
	}

	public SetChatStickerSet chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public SetChatStickerSet description(String description) {
		this.description = description;
		return this;
	}
}
