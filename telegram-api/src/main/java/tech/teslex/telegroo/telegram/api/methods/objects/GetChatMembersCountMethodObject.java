package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * getChatMembersCount
 * Use this method to get the number of members in a chat. Returns Int on success.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetChatMembersCountMethodObject implements MethodObject {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "getChatMembersCount";
	}
}
