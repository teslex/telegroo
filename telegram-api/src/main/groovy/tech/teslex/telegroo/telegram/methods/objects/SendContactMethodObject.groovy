package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.methods.MethodObjectAnnotations

/**
 * sendContact
 * Use this method to send phone contacts. On success, the sent Message is returned.
 */
@MethodObjectAnnotations
class SendContactMethodObject implements MethodObject {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = 'chat_id', required = true)
	def chatId

	/**
	 * Contact's phone number
	 */
	@JsonProperty(value = 'phone_number', required = true)
	String phoneNumber

	/**
	 * Contact's first name
	 */
	@JsonProperty(value = 'first_name', required = true)
	String firstName

	/**
	 * Contact's last name
	 */
	@JsonProperty(value = 'last_name', required = false)
	String lastName

	/**
	 * Additional data about the contact in the form of a vCard, 0-2048 bytes
	 */
	@JsonProperty(required = false)
	String vcard

	/**
	 * Sends the message silently. Users will receive a notification with no sound.
	 */
	@JsonProperty(value = 'disable_notification', required = false)
	Boolean disableNotification

	/**
	 * If the message is a reply, ID of the original message
	 */
	@JsonProperty(value = 'reply_to_message_id', required = false)
	Integer replyToMessageId

	/**
	 * Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
	 *
	 * InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply
	 */
	@JsonProperty(value = 'reply_markup', required = false)
	def replyMarkup

	@Override
	@JsonIgnore
	String getPathMethod() {
		'sendContact'
	}
}
