package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * getChatMember
 * Use this method to get information about a member of a chat. Returns a ChatMember object on success.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetChatMemberMethodObject implements MethodObject {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * Unique identifier of the target user
	 */
	@JsonProperty(value = "user_id", required = true)
	private Object user;

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "getChatMember";
	}
}
