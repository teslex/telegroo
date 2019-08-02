package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
	/**
	 * Unique identifier for this user or bot
	 */
	private Integer id;
	/**
	 * True, if this user is a bot
	 */
	@JsonProperty(value = "is_bot")
	private Boolean isBot;
	/**
	 * User‘s or bot’s first name
	 */
	@JsonProperty(value = "first_name")
	private String firstName;
	/**
	 * Optional. User‘s or bot’s last name
	 */
	@JsonProperty(value = "last_name", required = false)
	private String lastName;
	/**
	 * Optional. User‘s or bot’s username
	 */
	@JsonProperty(required = false)
	private String username;
	/**
	 * Optional. IETF language tag of the user's language
	 */
	@JsonProperty(value = "language_code", required = false)
	private String languageCode;
}
