package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.MapConstructor
import groovy.transform.ToString
import groovy.transform.builder.Builder
import tech.teslex.telegroo.telegram.methods.MethodObject

/**
 * sendVenue
 * Use this method to send information about a venue. On success, the sent Message is returned.
 */
@ToString
@MapConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@CompileStatic
@Builder
class SendVenueMethodObject implements MethodObject {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = 'chat_id', required = true)
	def chatId

	/**
	 * Latitude of the venue
	 */
	@JsonProperty(required = true)
	Float latitude

	/**
	 * Longitude of the venue
	 */
	@JsonProperty(required = true)
	Float longitude

	/**
	 * Name of the venue
	 */
	@JsonProperty(required = true)
	String title

	/**
	 * Address of the venue
	 */
	@JsonProperty(required = true)
	String address

	/**
	 * Foursquare identifier of the venue
	 */
	@JsonProperty(value = 'foursquare_id', required = false)
	String foursquareId

	/**
	 * Foursquare value of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
	 */
	@JsonProperty(value = 'foursquare_type', required = false)
	String foursquareType

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
	String getPathMethod() { 'sendVenue' }
}
