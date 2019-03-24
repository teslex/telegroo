package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.methods.MethodObjectAnnotations

/**
 * sendLocation
 * Use this method to send point on the map. On success, the sent Message is returned.
 */
@MethodObjectAnnotations
class SendLocationMethodObject implements MethodObject {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = 'chat_id', required = true)
	def chatId

	/**
	 * Latitude of the location
	 */
	@JsonProperty(required = true)
	Float latitude

	/**
	 * Longitude of the location
	 */
	@JsonProperty(required = true)
	Float longitude

	/**
	 * Period in seconds for which the location will be updated (see Live Locations, should be between 60 and 86400.
	 */
	@JsonProperty(value = 'live_period', required = false)
	Integer livePeriod

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
	String getPathMethod() { 'sendLocation' }
}