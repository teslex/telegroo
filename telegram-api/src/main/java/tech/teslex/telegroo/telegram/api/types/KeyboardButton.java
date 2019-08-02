package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KeyboardButton {
	/**
	 * Text of the button. If none of the optional fields are used, it will be sent as a message when the button is pressed
	 */
	private String text;
	/**
	 * Optional. If True, the user's phone number will be sent as a contact when the button is pressed. Available in private chats only
	 */
	@JsonProperty(value = "request_contact", required = false)
	private Boolean requestContact;
	/**
	 * Optional. If True, the user's current location will be sent when the button is pressed. Available in private chats only
	 */
	@JsonProperty(value = "request_location", required = false)
	private Boolean requestLocation;
}
