package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.MapConstructor
import groovy.transform.ToString
import groovy.transform.builder.Builder
import tech.teslex.telegroo.telegram.enums.ParseMode
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.types.InlineKeyboardMarkup

/**
 * editMessageText
 * Use this method to edit text and game messages sent by the bot or via the bot (for inline bots). On success, if edited message is sent by the bot, the edited Message is returned, otherwise True is returned.
 */
@ToString
@MapConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@CompileStatic
@Builder
class EditMessageTextMethodObject implements MethodObject {

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
	 * New text of the message
	 */
	@JsonProperty(required = true)
	String text

	/**
	 * Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in your bot's message.
	 */
	@JsonProperty(value = 'parse_mode', required = false)
	String parseMode

	/**
	 * Disables link previews for links in this message
	 */
	@JsonProperty(value = 'disable_web_page_preview', required = false)
	Boolean disableWebPagePreview

	/**
	 * A JSON-serialized object for an inline keyboard.
	 */
	@JsonProperty(value = 'reply_markup', required = false)
	InlineKeyboardMarkup replyMarkup

	@Override
	@JsonIgnore
	String getPathMethod() {
		'editMessageText'
	}

	void setParseMode(String parseMode) {
		this.parseMode = parseMode
	}

	@JsonIgnore
	void setParseMode(ParseMode parseMode) {
		this.parseMode = parseMode.value
	}
}
