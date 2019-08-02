package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * This object contains information about one answer option in a poll.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PollOption {
	/**
	 * Option text, 1-100 characters
	 */
	private String text;
	/**
	 * Number of users that voted for this option
	 */
	@JsonProperty(value = "voter_count")
	private Integer voterCount;
}
