package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object represents a chat.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Chat {

	/**
	 * Unique identifier for this chat. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float value are safe for storing this identifier.
	 */
	private Long id;
	/**
	 * Type of chat, can be either “private”, “group”, “supergroup” or “channel”
	 */
	private String type;
	/**
	 * Optional. Title, for supergroups, channels and group chats
	 */
	@JsonProperty(required = false)
	private String title;
	/**
	 * Optional. Username, for private chats, supergroups and channels if available
	 */
	@JsonProperty(required = false)
	private String username;
	/**
	 * Optional. First name of the other party in a private chat
	 */
	@JsonProperty(value = "first_name", required = false)
	private String firstName;
	/**
	 * Optional. Last name of the other party in a private chat
	 */
	@JsonProperty(value = "last_name", required = false)
	private String lastName;
	/**
	 * Optional. True if a group has ‘All Members Are Admins’ enabled.
	 */
	@JsonProperty(value = "all_members_are_administrators", required = false)
	private Boolean allMembersAreAdministrators;
	/**
	 * Optional. Chat photo. Returned only in getChat.
	 */
	@JsonProperty(required = false)
	private ChatPhoto photo;
	/**
	 * Optional. Description, for supergroups and channel chats. Returned only in getChat.
	 */
	@JsonProperty(required = false)
	private String description;
	/**
	 * Optional. Chat invite link, for supergroups and channel chats. Each administrator in a chat generates their own invite links, so the bot must first generate the link using exportChatInviteLink. Returned only in getChat.
	 */
	@JsonProperty(value = "invite_link", required = false)
	private String inviteLink;
	/**
	 * Optional. Pinned message, for supergroups and channel chats. Returned only in getChat.
	 */
	@JsonProperty(value = "pinned_message", required = false)
	private Message pinnedMessage;
	/**
	 * Optional. For supergroups, name of group sticker set. Returned only in getChat.
	 */
	@JsonProperty(value = "sticker_set_name", required = false)
	private String stickerSetName;
	/**
	 * Optional. True, if the bot can change the group sticker set. Returned only in getChat.
	 */
	@JsonProperty(value = "can_set_sticker_set", required = false)
	private Boolean canSetStickerSet;
}
