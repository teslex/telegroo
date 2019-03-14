package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.MapConstructor
import groovy.transform.ToString
import groovy.transform.builder.Builder
import tech.teslex.telegroo.telegram.methods.MethodObject

/**
 * getChatMembersCount
 * Use this method to get the number of members in a chat. Returns Int on success.
 */
@ToString
@MapConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@CompileStatic
@Builder
class GetChatMembersCountMethodObject implements MethodObject {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = 'chat_id', required = true)
	def chatId

	@Override
	String getPathMethod() {
		'getChatMembersCount'
	}
}
