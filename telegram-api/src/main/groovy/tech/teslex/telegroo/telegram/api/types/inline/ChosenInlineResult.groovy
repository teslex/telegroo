package tech.teslex.telegroo.telegram.api.types.inline


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.api.TypeAnnotations
import tech.teslex.telegroo.telegram.api.types.Location
import tech.teslex.telegroo.telegram.api.types.User

/**
 * Represents a result of an inline query that was chosen by the user and sent to their chat partner.
 */
@TypeAnnotations
class ChosenInlineResult {

	/**
	 * The unique identifier for the result that was chosen
	 */
	@JsonProperty(value = 'result_id')
	String resultId

	/**
	 * The user that chose the result
	 */
	User from

	/**
	 * Optional. Sender location, only for bots that require user location
	 */
	@JsonProperty(required = false)
	Location location

	/**
	 * Optional. Identifier of the sent inline message. Available only if there is an inline keyboard attached to the message. Will be also received in callback queries and can be used to edit the message.
	 */
	@JsonProperty(value = 'inline_message_id', required = false)
	String inlineMessageId

	/**
	 * The query that was used to obtain the result
	 */
	String query
}
