package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.methods.MethodObjectAnnotations
import tech.teslex.telegroo.telegram.types.InlineKeyboardMarkup

/**
 * editMessageCaption
 * Use this method to edit captions of messages sent by the bot or via the bot (for inline bots). On success, if edited message is sent by the bot, the edited Message is returned, otherwise True is returned.
 */
@MethodObjectAnnotations
class EditMessageCaptionMethodObject implements MethodObject {

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
	 * New caption of the message
	 */
	@JsonProperty(required = false)
	String caption

	/**
	 * Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
	 */
	@JsonProperty(value = 'parse_mode', required = false)
	String parseMode

	/**
	 * A JSON-serialized object for an inline keyboard.
	 */
	@JsonProperty(value = 'reply_markup', required = false)
	InlineKeyboardMarkup replyMarkup

	@Override
	@JsonIgnore
	String getPathMethod() {
		'editMessageCaption'
	}

	void setParseMode(String parseMode) {
		this.parseMode = parseMode
	}


}
