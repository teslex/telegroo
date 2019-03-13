package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.MapConstructor
import groovy.transform.ToString

@ToString
@MapConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@CompileStatic
class ForwardMessageMethodObject {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 *
	 * Integer or String
	 */
	@JsonProperty(value = 'chat_id', required = true)
	def chatId

	/**
	 * Unique identifier for the chat where the original message was sent (or channel username in the format @channelusername)
	 *
	 * Integer or String
	 */
	@JsonProperty(value = 'from_chat_id', required = true)
	def fromChatId

	/**
	 * Sends the message silently. Users will receive a notification with no sound.
	 */
	@JsonProperty(value = 'disable_notification', required = false)
	Boolean disableNotification

	/**
	 * Message identifier in the chat specified in from_chat_id
	 */
	@JsonProperty(value = 'message_id', required = true)
	Integer messageId
}
