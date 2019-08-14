package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * leaveChat
 * Use this method for your bot to leave a group, supergroup or channel. Returns True on success.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LeaveChat implements MethodObject {
	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;

	public static LeaveChat create() {
		return new LeaveChat();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "leaveChat";
	}

	public LeaveChat chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}
}
