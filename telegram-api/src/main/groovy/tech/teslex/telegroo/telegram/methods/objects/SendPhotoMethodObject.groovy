package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.methods.MethodObjectAnnotations
import tech.teslex.telegroo.telegram.methods.MethodObjectWithFile
import tech.teslex.telegroo.telegram.types.input.InputFile

/**
 * sendPhoto
 * Use this method to send photos. On success, the sent Message is returned.
 */
@MethodObjectAnnotations
class SendPhotoMethodObject implements MethodObjectWithFile {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 *
	 * Integer or String
	 */
	@JsonProperty(value = 'chat_id', required = true)
	def chatId

	/**
	 * Photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet, or upload a new photo using multipart/form-data. More info on Sending Files »
	 */
	@JsonIgnore
	InputFile photo

	/**
	 * Photo caption (may also be used when resending photos by file_id), 0-1024 characters
	 */
	@JsonProperty(required = false)
	String caption

	/**
	 * Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
	 */
	@JsonProperty(value = 'parse_mode', required = false)
	String parseMode

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
	InputFile getFile() {
		this.photo
	}

	void setParseMode(String parseMode) {
		this.parseMode = parseMode
	}


	@Override
	@JsonIgnore
	String getPathMethod() { 'sendPhoto' }
}