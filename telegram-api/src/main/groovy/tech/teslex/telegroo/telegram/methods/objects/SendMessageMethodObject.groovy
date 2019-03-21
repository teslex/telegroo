package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.Canonical
import groovy.transform.CompileStatic
import groovy.transform.MapConstructor
import groovy.transform.builder.Builder
import tech.teslex.telegroo.telegram.enums.ParseMode
import tech.teslex.telegroo.telegram.methods.MethodObject

/**
 * sendMessage
 * Use this method to send text messages. On success, the sent Message is returned.
 */
@Canonical
@MapConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@CompileStatic
@Builder
class SendMessageMethodObject implements MethodObject {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = 'chat_id', required = true)
	def chatId

	/**
	 * Text of the message to be sent
	 */
	@JsonProperty(required = true)
	String text

	/**
	 * Disables link previews for links in this message
	 */
	@JsonProperty(value = 'disable_web_page_preview', required = false)
	Boolean disableWebPagePreview

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

	/**
	 * Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in your bot's message.
	 */
	@JsonProperty(value = 'parse_mode', required = false)
	String parseMode

	@Override
	@JsonIgnore
	String getPathMethod() { 'sendMessage' }

	void setParseMode(String parseMode) {
		this.parseMode = parseMode
	}

	@JsonIgnore
	void setParseMode(ParseMode parseMode) {
		this.parseMode = parseMode.value
	}
}