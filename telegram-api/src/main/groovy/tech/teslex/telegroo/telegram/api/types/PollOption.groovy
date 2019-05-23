package tech.teslex.telegroo.telegram.api.types

import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.api.TypeAnnotations

/**
 * This object contains information about one answer option in a poll.
 */
@TypeAnnotations
class PollOption {

	/**
	 * Option text, 1-100 characters
	 */
	String text

	/**
	 * Number of users that voted for this option
	 */
	@JsonProperty(value = 'voter_count')
	Integer voterCount
}
