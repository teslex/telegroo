package tech.teslex.telegroo.telegram.api.types

import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.api.TypeAnnotations

/**
 * This object contains information about a poll.
 */
@TypeAnnotations
class Poll {

	/**
	 * Unique poll identifier
	 */
	String id

	/**
	 * Poll question, 1-255 characters
	 */
	String question

	/**
	 * List of poll options
	 */
	List<PollOption> options

	/**
	 * True, if the poll is closed
	 */
	@JsonProperty(value = 'is_closed')
	Boolean isClosed
}
