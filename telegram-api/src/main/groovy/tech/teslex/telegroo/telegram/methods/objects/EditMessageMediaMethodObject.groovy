package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.MapConstructor
import groovy.transform.ToString
import groovy.transform.builder.Builder
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.types.InlineKeyboardMarkup
import tech.teslex.telegroo.telegram.types.InputMedia

/**
 * editMessageMedia
 * Use this method to edit animation, audio, document, photo, or video messages. If a message is a part of a message album, then it can be edited only to a photo or a video. Otherwise, message value can be changed arbitrarily. When inline message is edited, new file can't be uploaded. Use previously uploaded file via its file_id or specify a URL. On success, if the edited message was sent by the bot, the edited Message is returned, otherwise True is returned.
 */
@ToString
@MapConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@CompileStatic
@Builder
class EditMessageMediaMethodObject implements MethodObject {

	/**
	 * Required if inline_message_id is not specified. Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = 'chat_id', required = false)
	def chatId

	/**
	 * Required if inline_message_id is not specified. Identifier of the sent message
	 */
	@JsonProperty(value = 'message_id', required = false)
	Integer messageId

	/**
	 * Required if chat_id and message_id are not specified. Identifier of the inline message
	 */
	@JsonProperty(value = 'inline_message_id', required = false)
	String inlineMessageId

	/**
	 * A JSON-serialized object for a new media content of the message
	 */
	@JsonProperty(required = true)
	List<InputMedia> media

	/**
	 * A JSON-serialized object for a new inline keyboard.
	 */
	@JsonProperty(value = 'reply_markup', required = false)
	InlineKeyboardMarkup replyMarkup

	@Override
	@JsonIgnore
	String getPathMethod() {
		'editMessageMedia'
	}
}
