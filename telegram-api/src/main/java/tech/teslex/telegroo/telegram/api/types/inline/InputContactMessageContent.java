package tech.teslex.telegroo.telegram.api.types.inline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents the content of a contact message to be sent as the result of an inline query.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InputContactMessageContent extends InputMessageContent {
	/**
	 * Contact's phone number
	 */
	@JsonProperty(value = "phone_number")
	private String phoneNumber;
	/**
	 * Contact's first name
	 */
	@JsonProperty(value = "first_name")
	private String firstName;
	/**
	 * Optional. Contact's last name
	 */
	@JsonProperty(value = "last_name", required = false)
	private String lastName;
	/**
	 * Optional. Additional data about the contact in the form of a vCard, 0-2048 bytes
	 */
	@JsonProperty(required = false)
	private String vcard;
}
