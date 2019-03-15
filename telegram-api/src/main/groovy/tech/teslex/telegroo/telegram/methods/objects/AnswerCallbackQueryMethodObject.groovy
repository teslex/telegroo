package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.MapConstructor
import groovy.transform.ToString
import groovy.transform.builder.Builder
import tech.teslex.telegroo.telegram.methods.MethodObject

/**
 * answerCallbackQuery
 * Use this method to send answers to callback queries sent from inline keyboards. The answer will be displayed to the user as a notification at the top of the chat screen or as an alert. On success, True is returned.
 */
@ToString
@MapConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@CompileStatic
@Builder
class AnswerCallbackQueryMethodObject implements MethodObject {

	/**
	 * Unique identifier for the query to be answered
	 */
	@JsonProperty(value = 'callback_query_id', required = true)
	String callbackQueryId

	/**
	 * Text of the notification. If not specified, nothing will be shown to the user, 0-200 characters
	 */
	@JsonProperty(required = false)
	String text

	/**
	 * If true, an alert will be shown by the client instead of a notification at the top of the chat screen. Defaults to false.
	 */
	@JsonProperty(value = 'show_alert', required = false)
	Boolean showAlert

	/**
	 * URL that will be opened by the user's client. If you have created a Game and accepted the conditions via @Botfather, specify the URL that opens your game – note that this will only work if the query comes from a callback_game button.
	 */
	@JsonProperty(required = false)
	String url

	/**
	 * The maximum amount of time in seconds that the result of the callback query may be cached client-side. Telegram apps will support caching starting in version 3.14. Defaults to 0.
	 */
	@JsonProperty(value = 'cache_time', required = false)
	Integer cacheTime

	@Override
	@JsonIgnore
	String getPathMethod() {
		'answerCallbackQuery'
	}
}
