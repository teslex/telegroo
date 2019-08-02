package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * promoteChatMember
 * Use this method to promote or demote a user in a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Pass False for all boolean parameters to demote a user. Returns True on success.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PromoteChatMemberMethodObject implements MethodObject {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * Unique identifier of the target user
	 */
	@JsonProperty(value = "user_id", required = true)
	private Integer userId;
	/**
	 * Pass True, if the administrator can change chat title, photo and other settings
	 */
	@JsonProperty(value = "can_change_info", required = false)
	private Boolean canChangeInfo;
	/**
	 * Pass True, if the administrator can create channel posts, channels only
	 */
	@JsonProperty(value = "can_post_messages", required = false)
	private Boolean canPostMessages;
	/**
	 * Pass True, if the administrator can edit messages of other users and can pin messages, channels only
	 */
	@JsonProperty(value = "can_edit_messages", required = false)
	private Boolean canEditMessages;
	/**
	 * Pass True, if the administrator can delete messages of other users
	 */
	@JsonProperty(value = "can_delete_messages", required = false)
	private Boolean canDeleteMessages;
	/**
	 * Pass True, if the administrator can invite new users to the chat
	 */
	@JsonProperty(value = "can_invite_users", required = false)
	private Boolean canInviteUsers;
	/**
	 * Pass True, if the administrator can restrict, ban or unban chat members
	 */
	@JsonProperty(value = "can_restrict_members", required = false)
	private Boolean canRestrictMembers;
	/**
	 * Pass True, if the administrator can pin messages, supergroups only
	 */
	@JsonProperty(value = "can_pin_messages", required = false)
	private Boolean canPinMessages;
	/**
	 * Pass True, if the administrator can add new administrators with a subset of his own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by him)
	 */
	@JsonProperty(value = "can_promote_members", required = false)
	private Boolean canPromoteMembers;

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "promoteChatMember";
	}
}
