package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * sendLocation
 * Use this method to send point on the map. On success, the sent Message is returned.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendLocation implements MethodObject {
	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * Latitude of the location
	 */
	@JsonProperty(required = true)
	private Float latitude;
	/**
	 * Longitude of the location
	 */
	@JsonProperty(required = true)
	private Float longitude;
	/**
	 * Period in seconds for which the location will be updated (see Live Locations, should be between 60 and 86400.
	 */
	@JsonProperty(value = "live_period", required = false)
	private Integer livePeriod;
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

	public static SendLocation create() {
		return new SendLocation();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "sendLocation";
	}

	public SendLocation chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public SendLocation latitude(Float latitude) {
		this.latitude = latitude;
		return this;
	}

	public SendLocation longitude(Float longitude) {
		this.longitude = longitude;
		return this;
	}

	public SendLocation livePeriod(Integer livePeriod) {
		this.livePeriod = livePeriod;
		return this;
	}

	public SendLocation disableNotification(Boolean disableNotification) {
		this.disableNotification = disableNotification;
		return this;
	}

	public SendLocation replyToMessageId(Integer replyToMessageId) {
		this.replyToMessageId = replyToMessageId;
		return this;
	}

	public SendLocation replyMarkup(Object replyMarkup) {
		this.replyMarkup = replyMarkup;
		return this;
	}
}
