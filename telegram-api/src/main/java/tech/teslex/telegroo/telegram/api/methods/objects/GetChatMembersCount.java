package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * getChatMembersCount
 * Use this method to get the number of members in a chat. Returns Int on success.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetChatMembersCount implements MethodObject {
	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;

	public static GetChatMembersCount create() {
		return new GetChatMembersCount();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "getChatMembersCount";
	}

	public GetChatMembersCount chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}
}
