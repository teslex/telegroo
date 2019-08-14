package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * sendVenue
 * Use this method to send information about a venue. On success, the sent Message is returned.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendVenue implements MethodObject {
	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * Latitude of the venue
	 */
	@JsonProperty(required = true)
	private Float latitude;
	/**
	 * Longitude of the venue
	 */
	@JsonProperty(required = true)
	private Float longitude;
	/**
	 * Name of the venue
	 */
	@JsonProperty(required = true)
	private String title;
	/**
	 * Address of the venue
	 */
	@JsonProperty(required = true)
	private String address;
	/**
	 * Foursquare identifier of the venue
	 */
	@JsonProperty(value = "foursquare_id", required = false)
	private String foursquareId;
	/**
	 * Foursquare value of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
	 */
	@JsonProperty(value = "foursquare_type", required = false)
	private String foursquareType;
	/**
	 * Sends the message silently. Users will receive a notification with no sound.
	 */
	@JsonProperty(value = "disable_notification", required = false)
	private Boolean disableNotification;
	/**
	 * If the message is a reply, ID of the original message
	 */
	@JsonProperty(value = "reply_to_message_id", required = false)
	private Integer replyToMessageId;
	/**
	 * Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
	 * <p>
	 * InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply
	 */
	@JsonProperty(value = "reply_markup", required = false)
	private Object replyMarkup;

	public static SendVenue create() {
		return new SendVenue();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "sendVenue";
	}

	public SendVenue chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public SendVenue latitude(Float latitude) {
		this.latitude = latitude;
		return this;
	}

	public SendVenue longitude(Float longitude) {
		this.longitude = longitude;
		return this;
	}

	public SendVenue title(String title) {
		this.title = title;
		return this;
	}

	public SendVenue address(String address) {
		this.address = address;
		return this;
	}

	public SendVenue foursquareId(String foursquareId) {
		this.foursquareId = foursquareId;
		return this;
	}

	public SendVenue foursquareType(String foursquareType) {
		this.foursquareType = foursquareType;
		return this;
	}

	public SendVenue disableNotification(Boolean disableNotification) {
		this.disableNotification = disableNotification;
		return this;
	}

	public SendVenue replyToMessageId(Integer replyToMessageId) {
		this.replyToMessageId = replyToMessageId;
		return this;
	}

	public SendVenue replyMarkup(Object replyMarkup) {
		this.replyMarkup = replyMarkup;
		return this;
	}
}
