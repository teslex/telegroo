package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.methods.MethodObjectAnnotations

/**
 * getChatMembersCount
 * Use this method to get the number of members in a chat. Returns Int on success.
 */
@MethodObjectAnnotations
class GetChatMembersCountMethodObject implements MethodObject {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = 'chat_id', required = true)
	def chatId

	@Override
	@JsonIgnore
	String getPathMethod() {
		'getChatMembersCount'
	}
}
