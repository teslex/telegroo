package tech.teslex.telegroo.telegram.types.inline

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.Canonical
import groovy.transform.builder.Builder

/**
 * Represents the content of a text message to be sent as the result of an inline query.
 */
@Canonical
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class InputTextMessageContent extends InputMessageContent {

	/**
	 * Text of the message to be sent, 1-4096 characters
	 */
	@JsonProperty(value = 'message_text')
	String messageText

	/**
	 * Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in your bot's message.
	 */
	@JsonProperty(value = 'parse_mode', required = false)
	String parseMode

	/**
	 * Optional. Disables link previews for links in the sent message
	 */
	@JsonProperty(value = 'disable_web_page_preview', required = false)
	Boolean disableWebPagePreview
}
