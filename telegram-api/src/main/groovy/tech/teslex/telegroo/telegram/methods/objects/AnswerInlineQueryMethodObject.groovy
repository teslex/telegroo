package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.methods.MethodObjectAnnotations
import tech.teslex.telegroo.telegram.types.inline.InlineQueryResult

/**
 * answerInlineQuery
 * Use this method to send answers to an inline query. On success, True is returned.
 * No more than 50 results per query are allowed.
 */
@MethodObjectAnnotations
class AnswerInlineQueryMethodObject implements MethodObject {

	/**
	 * Unique identifier for the answered query
	 */
	@JsonProperty(value = 'inline_query_id', required = true)
	String inlineQueryId

	/**
	 * A JSON-serialized array of results for the inline query
	 */
	@JsonProperty(required = true)
	List<InlineQueryResult> results

	/**
	 * The maximum amount of time in seconds that the result of the inline query may be cached on the server. Defaults to 300.
	 */
	@JsonProperty(value = 'cache_time', required = false)
	Integer cacheTime

	/**
	 * Pass True, if results may be cached on the server side only for the user that sent the query. By default, results may be returned to any user who sends the same query
	 */
	@JsonProperty(value = 'is_personal', required = false)
	Boolean isPersonal

	/**
	 * Pass the offset that a client should send in the next query with the same text to receive more results. Pass an empty string if there are no more results or if you don‘t support pagination. Offset length can’t exceed 64 bytes.
	 */
	@JsonProperty(value = 'next_offset', required = false)
	String nextOffset

	/**
	 * If passed, clients will display a button with specified text that switches the user to a private chat with the bot and sends the bot a start message with the parameter switch_pm_parameter
	 */
	@JsonProperty(value = 'switch_pm_text', required = false)
	String switchPmText

	/**
	 * Deep-linking parameter for the /start message sent to the bot when user presses the switch button. 1-64 characters, only A-Z, a-z, 0-9, _ and - are allowed.
	 */
	@JsonProperty(value = 'switch_pm_parameter', required = false)
	String switchPmParameter

	@Override
	@JsonIgnore
	String getPathMethod() {
		'answerInlineQuery'
	}
}
