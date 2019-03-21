package tech.teslex.telegroo.telegram.methods.objects.games

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.MapConstructor
import groovy.transform.ToString
import groovy.transform.builder.Builder
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.types.InlineKeyboardMarkup

/**
 * sendGame
 * Use this method to send a game. On success, the sent Message is returned.
 */
@ToString
@MapConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@CompileStatic
@Builder
class SendGameMethodObject implements MethodObject {

	/**
	 * Unique identifier for the target chat
	 */
	@JsonProperty(value = 'chat_id', required = true)
	def chatId

	/**
	 * Short name of the game, serves as the unique identifier for the game. Set up your games via Botfather.
	 */
	@JsonProperty(value = 'game_short_name', required = true)
	String gameShortName

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
	 * A JSON-serialized object for an inline keyboard. If empty, one ‘Play game_title’ button will be shown. If not empty, the first button must launch the game.
	 */
	@JsonProperty(value = 'reply_markup', required = false)
	InlineKeyboardMarkup replyMarkup

	@Override
	@JsonIgnore
	String getPathMethod() {
		'sendGame'
	}
}
