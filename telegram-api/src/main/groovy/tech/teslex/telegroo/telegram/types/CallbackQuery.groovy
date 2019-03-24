package tech.teslex.telegroo.telegram.types


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.TypeAnnotations

@TypeAnnotations
class CallbackQuery {

	/**
	 * Unique identifier for this query
	 */
	String cid

	/**
	 * Sender
	 */
	User from

	/**
	 * Optional. Message with the callback button that originated the query. Note that message content and message date will not be available if the message is too old
	 */
	@JsonProperty(required = false)
	Message message

	/**
	 * Optional. Identifier of the message sent via the bot in inline mode, that originated the query.
	 */
	@JsonProperty(value = 'inline_message_id', required = false)
	String inlineMessageId

	/**
	 * Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent. Useful for high scores in games.
	 */
	@JsonProperty(value = 'chat_instance')
	String chatInstance

	/**
	 * Optional. Data associated with the callback button. Be aware that a bad client can send arbitrary data in this field.
	 */
	@JsonProperty(required = false)
	String data

	/**
	 * Optional. Short name of a Game to be returned, serves as the unique identifier for the game
	 */
	@JsonProperty(value = 'game_short_name', required = false)
	String gameShortName
}
