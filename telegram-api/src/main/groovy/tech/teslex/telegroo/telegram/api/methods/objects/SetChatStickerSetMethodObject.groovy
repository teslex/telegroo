package tech.teslex.telegroo.telegram.api.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.api.methods.MethodObject
import tech.teslex.telegroo.telegram.api.methods.MethodObjectAnnotations

/**
 * setChatDescription
 * Use this method to change the description of a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns True on success.
 */
@MethodObjectAnnotations
class SetChatStickerSetMethodObject implements MethodObject {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = 'chat_id', required = true)
	def chatId

	/**
	 * New chat description, 1-255 characters
	 */
	@JsonProperty(required = true)
	String description

	@Override
	@JsonIgnore
	String getPathMethod() {
		'setChatDescription'
	}
}
