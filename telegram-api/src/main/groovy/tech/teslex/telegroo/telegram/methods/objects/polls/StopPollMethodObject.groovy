package tech.teslex.telegroo.telegram.methods.objects.polls

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.methods.MethodObjectAnnotations
import tech.teslex.telegroo.telegram.types.InlineKeyboardMarkup

/**
 * stopPoll
 * Use this method to stop a poll which was sent by the bot. On success, the stopped Poll with the final results is returned.
 */
@MethodObjectAnnotations
class StopPollMethodObject implements MethodObject {

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = 'chat_id', required = true)
	def chatId

	/**
	 * Identifier of the original message with the poll
	 */
	@JsonProperty(value = 'message_id')
	Integer messageId

	/**
	 * A JSON-serialized object for a new message inline keyboard.
	 */
	@JsonProperty(value = 'reply_markup', required = false)
	InlineKeyboardMarkup replyMarkup

	@Override
	@JsonIgnore
	String getPathMethod() {
		'stopPoll'
	}
}
