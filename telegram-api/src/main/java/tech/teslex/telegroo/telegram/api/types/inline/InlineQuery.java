package tech.teslex.telegroo.telegram.api.types.inline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.types.Location;
import tech.teslex.telegroo.telegram.api.types.User;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InlineQuery {
	/**
	 * Unique identifier for this query
	 */
	private String id;
	/**
	 * Sender
	 */
	private User from;
	/**
	 * Optional. Sender location, only for bots that request user location
	 */
	@JsonProperty(required = false)
	private Location location;
	/**
	 * Text of the query (up to 512 characters)
	 */
	private String query;
	/**
	 * Offset of the results to be returned, can be controlled by the bot
	 */
	private String offset;
}
