package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * setChatStickerSet
 * Use this method to set a new group sticker set for a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Use the field can_set_sticker_set optionally returned in getChat requests to check if the bot can use this method. Returns True on success.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetChatDescription implements MethodObject {
	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * Name of the sticker set to be set as the group sticker set
	 */
	@JsonProperty(value = "sticker_set_name", required = true)
	private String stickerSetName;

	public static SetChatDescription create() {
		return new SetChatDescription();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "setChatStickerSet";
	}

	public SetChatDescription chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public SetChatDescription stickerSetName(String stickerSetName) {
		this.stickerSetName = stickerSetName;
		return this;
	}
}
