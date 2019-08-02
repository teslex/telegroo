package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact {
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
	 * Optional. Contact's user identifier in Telegram
	 */
	@JsonProperty(value = "user_id", required = false)
	private Integer userId;
	/**
	 * Optional. Additional data about the contact in the form of a vCard
	 */
	@JsonProperty(required = false)
	private String vcard;
}
