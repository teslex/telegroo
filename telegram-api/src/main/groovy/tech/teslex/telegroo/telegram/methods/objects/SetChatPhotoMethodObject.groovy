package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.methods.MethodObjectAnnotations
import tech.teslex.telegroo.telegram.methods.MethodObjectWithFile
import tech.teslex.telegroo.telegram.attach.InputFile

/**
 * setChatPhoto
 * Use this method to set a new profile photo for the chat. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns True on success.
 */
@MethodObjectAnnotations
class SetChatPhotoMethodObject implements MethodObjectWithFile {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = 'chat_id', required = true)
	def chatId

	@JsonIgnore
	InputFile photo

	@Override
	@JsonIgnore
	String getPathMethod() {
		'setChatPhoto'
	}

	@Override
	@JsonIgnore
	InputFile getFile() {
		this.photo
	}
}
