package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * unbanChatMember
 * Use this method to unban a previously kicked user in a supergroup or channel. The user will not return to the group or channel automatically, but will be able to join via link, etc. The bot must be an administrator for this to work. Returns True on success.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UnbanChatMemberMethodObject implements MethodObject {
	/**
	 * Unique identifier for the target group or username of the target supergroup or channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * Unique identifier of the target user
	 */
	@JsonProperty(value = "user_id", required = true)
	private Integer userId;

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "unbanChatMember";
	}

	public Object getChatId() {
		return chatId;
	}

	public void setChatId(Object chatId) {
		this.chatId = chatId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
