package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * kickChatMember
 * Use this method to kick a user from a group, a supergroup or a channel. In the case of supergroups and channels, the user will not be able to return to the group on their own using invite links, etc., unless unbanned first. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns True on success.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KickChatMember implements MethodObject {
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
	/**
	 * Date when the user will be unbanned, unix time. If user is banned for more than 366 days or less than 30 seconds from the current time they are considered to be banned forever
	 */
	@JsonProperty(value = "until_date", required = false)
	private Integer untilDate;

	public static KickChatMember create() {
		return new KickChatMember();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "kickChatMember";
	}

	public KickChatMember chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public KickChatMember userId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public KickChatMember untilDate(Integer untilDate) {
		this.untilDate = untilDate;
		return this;
	}
}
