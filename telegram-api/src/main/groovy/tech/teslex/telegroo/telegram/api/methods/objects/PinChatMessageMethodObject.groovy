package tech.teslex.telegroo.telegram.api.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.api.methods.MethodObject
import tech.teslex.telegroo.telegram.api.methods.MethodObjectAnnotations

/**
 * pinChatMessage
 * Use this method to pin a message in a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the ‘can_pin_messages’ admin right in the supergroup or ‘can_edit_messages’ admin right in the channel. Returns True on success.
 */
@MethodObjectAnnotations
class PinChatMessageMethodObject implements MethodObject {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = 'chat_id', required = true)
	def chatId

	/**
	 * Identifier of a message to pin
	 */
	@JsonProperty(value = 'message_id', required = true)
	Integer messageId

	/**
	 * Pass True, if it is not necessary to send a notification to all chat members about the new pinned message. Notifications are always disabled in channels.
	 */
	@JsonProperty(value = 'disable_notification', required = false)
	Boolean disableNotification

	@Override
	@JsonIgnore
	String getPathMethod() {
		'pinChatMessage'
	}
}
