package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.methods.MethodObjectAnnotations
import tech.teslex.telegroo.telegram.methods.MethodObjectWithMedia
import tech.teslex.telegroo.telegram.types.input.InputMedia

/**
 * sendMediaGroup
 * Use this method to send a group of photos or videos as an album. On success, an array of the sent Messages is returned.
 */
@MethodObjectAnnotations
class SendMediaGroupMethodObject implements MethodObjectWithMedia {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 *
	 * Integer or String
	 */
	@JsonProperty(value = 'chat_id', required = true)
	def chatId

	/**
	 * A JSON-serialized array describing photos and videos to be sent, must include 2–10 items
	 */
	@JsonIgnore
	List<InputMedia> media

	/**
	 * Sends the messages silently. Users will receive a notification with no sound.
	 */
	@JsonProperty(value = 'disable_notification', required = false)
	Boolean disableNotification

	/**
	 * If the messages are a reply, ID of the original message
	 */
	@JsonProperty(value = 'reply_to_message_id', required = false)
	Integer replyToMessageId

	SendMediaGroupMethodObject() { super() }

	@Override
	@JsonIgnore
	String getPathMethod() { 'sendMediaGroup' }
}