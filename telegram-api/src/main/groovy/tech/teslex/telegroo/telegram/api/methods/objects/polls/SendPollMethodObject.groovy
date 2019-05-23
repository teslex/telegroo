package tech.teslex.telegroo.telegram.api.methods.objects.polls

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.api.methods.MethodObject
import tech.teslex.telegroo.telegram.api.methods.MethodObjectAnnotations

/**
 * sendPoll
 * Use this method to send a native poll. A native poll can't be sent to a private chat. On success, the sent Message is returned.
 */
@MethodObjectAnnotations
class SendPollMethodObject implements MethodObject {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = 'chat_id', required = true)
	def chatId

	/**
	 * Poll question, 1-255 characters
	 */
	@JsonProperty(required = true)
	String question

	/**
	 * List of answer options, 2-10 strings 1-100 characters each
	 */
	@JsonProperty(required = true)
	List<String> options

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
		'sendPoll'
	}
}
