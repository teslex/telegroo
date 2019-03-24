package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.methods.MethodObjectAnnotations

/**
 * stopMessageLiveLocation
 * Use this method to stop updating a live location message sent by the bot or via the bot (for inline bots) before live_period expires. On success, if the message was sent by the bot, the sent Message is returned, otherwise True is returned.
 */
@MethodObjectAnnotations
class StopMessageLiveLocationMethodObject implements MethodObject {

	/**
	 * Required if inline_message_id is not specified. Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = 'chat_id', required = true)
	def chatId

	/**
	 * Required if inline_message_id is not specified. Identifier of the sent message
	 */
	@JsonProperty(value = 'message_id\t', required = false)
	String messageId

	/**
	 * Required if chat_id and message_id are not specified. Identifier of the inline message
	 */
	@JsonProperty(value = 'inline_message_id', required = false)
	String inlineMessageId

	/**
	 * A JSON-serialized object for a new inline keyboard.
	 *
	 * InlineKeyboardMarkup
	 */
	@JsonProperty(value = 'reply_markup', required = false)
	def replyMarkup

	@Override
	@JsonIgnore
	String getPathMethod() { 'stopMessageLiveLocation' }
}