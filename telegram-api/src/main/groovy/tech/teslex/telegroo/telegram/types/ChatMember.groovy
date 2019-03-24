package tech.teslex.telegroo.telegram.types


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.TypeAnnotations

@TypeAnnotations
class ChatMember {

	/**
	 * Information about the user
	 */
	User user

	/**
	 * The member's status in the chat. Can be “creator”, “administrator”, “member”, “restricted”, “left” or “kicked”
	 */
	String status

	/**
	 * Optional. Restricted and kicked only. Date when restrictions will be lifted for this user, unix time
	 */
	@JsonProperty(value = 'until_date', required = false)
	Integer untilDate

	/**
	 * Optional. Administrators only. True, if the bot is allowed to edit administrator privileges of that user
	 */
	@JsonProperty(value = 'can_be_edited', required = false)
	Boolean canBeEdited

	/**
	 * Optional. Administrators only. True, if the administrator can change the chat title, photo and other settings
	 */
	@JsonProperty(value = 'can_change_info', required = false)
	Boolean canChangeInfo

	/**
	 * Optional. Administrators only. True, if the administrator can post in the channel, channels only
	 */
	@JsonProperty(value = 'can_post_messages', required = false)
	Boolean canPostMessages

	/**
	 * Optional. Administrators only. True, if the administrator can edit messages of other users and can pin messages, channels only
	 */
	@JsonProperty(value = 'can_edit_messages', required = false)
	Boolean canEditMessages

	/**
	 * Optional. Administrators only. True, if the administrator can delete messages of other users
	 */
	@JsonProperty(value = 'can_delete_messages', required = false)
	Boolean canDeleteMessages

	/**
	 * Optional. Administrators only. True, if the administrator can invite new users to the chat
	 */
	@JsonProperty(value = 'can_invite_users', required = false)
	Boolean canInviteUsers

	/**
	 * Optional. Administrators only. True, if the administrator can restrict, ban or unban chat members
	 */
	@JsonProperty(value = 'can_restrict_members', required = false)
	Boolean canRestrictMembers

	/**
	 * Optional. Administrators only. True, if the administrator can pin messages, supergroups only
	 */
	@JsonProperty(value = 'can_pin_messages', required = false)
	Boolean canPinMessages

	/**
	 * Optional. Administrators only. True, if the administrator can add new administrators with a subset of his own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by the user)
	 */
	@JsonProperty(value = 'can_promote_members', required = false)
	Boolean canPromoteMembers

	/**
	 * Optional. Restricted only. True, if the user can send text messages, contacts, locations and venues
	 */
	@JsonProperty(value = 'can_send_messages', required = false)
	Boolean canSendMessages

	/**
	 * Optional. Restricted only. True, if the user can send audios, documents, photos, videos, video notes and voice notes, implies can_send_messages
	 */
	@JsonProperty(value = 'can_send_media_messages', required = false)
	Boolean canSendMediaMessages

	/**
	 * Optional. Restricted only. True, if the user can send animations, games, stickers and use inline bots, implies can_send_media_messages
	 */
	@JsonProperty(value = 'can_send_other_messages', required = false)
	Boolean canSendOtherMessages

	/**
	 * Optional. Restricted only. True, if user may add web page previews to his messages, implies can_send_media_messages
	 */
	@JsonProperty(value = 'can_add_web_page_previews', required = false)
	Boolean canAddWebPagePreviews
}
