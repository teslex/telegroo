package tech.teslex.telegroo.telegram.types

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.ToString

/**
 * This object represents a chat.
 */
@ToString
@CompileStatic
class Chat {

	/**
	 * Unique identifier for this chat. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
	 */
	Long id

	/**
	 * Type of chat, can be either “private”, “group”, “supergroup” or “channel”
	 */
	String type

	/**
	 * Optional. Title, for supergroups, channels and group chats
	 */
	@JsonProperty(required = false)
	String title

	/**
	 * Optional. Username, for private chats, supergroups and channels if available
	 */
	@JsonProperty(required = false)
	String username

	/**
	 * Optional. First name of the other party in a private chat
	 */
	@JsonProperty(value = 'first_name', required = false)
	String firstName

	/**
	 * Optional. Last name of the other party in a private chat
	 */
	@JsonProperty(value = 'last_name', required = false)
	String lastName

	/**
	 * Optional. True if a group has ‘All Members Are Admins’ enabled.
	 */
	@JsonProperty(value = 'all_members_are_administrators', required = false)
	Boolean allMembersAreAdministrators

	/**
	 * Optional. Chat photo. Returned only in getChat.
	 */
	@JsonProperty(required = false)
	ChatPhoto photo

	/**
	 * Optional. Description, for supergroups and channel chats. Returned only in getChat.
	 */
	@JsonProperty(required = false)
	String description

	/**
	 * Optional. Chat invite link, for supergroups and channel chats. Each administrator in a chat generates their own invite links, so the bot must first generate the link using exportChatInviteLink. Returned only in getChat.
	 */
	@JsonProperty(value = 'invite_link', required = false)
	String inviteLink

	/**
	 * Optional. Pinned message, for supergroups and channel chats. Returned only in getChat.
	 */
	@JsonProperty(value = 'pinned_message', required = false)
	Message pinnedMessage

	/**
	 * Optional. For supergroups, name of group sticker set. Returned only in getChat.
	 */
	@JsonProperty(value = 'sticker_set_name', required = false)
	String stickerSetName

	/**
	 * Optional. True, if the bot can change the group sticker set. Returned only in getChat.
	 */
	@JsonProperty(value = 'can_set_sticker_set', required = false)
	Boolean canSetStickerSet
}
