package tech.teslex.telegroo.telegram.api.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.api.methods.MethodObject
import tech.teslex.telegroo.telegram.api.methods.MethodObjectAnnotations

/**
 * getChat
 * Use this method to get up to date information about the chat (current name of the user for one-on-one conversations, current username of a user, group or channel, etc.). Returns a Chat object on success.
 */
@MethodObjectAnnotations
class GetChatMethodObject implements MethodObject {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = 'chat_id', required = true)
	def chatId

	@Override
	@JsonIgnore
	String getPathMethod() {
		'getChat'
	}
}
