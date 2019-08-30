package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * editMessageLiveLocation
 * Use this method to edit live location messages sent by the bot or via the bot (for inline bots). A location can be edited until its live_period expires or editing is explicitly disabled by a call to stopMessageLiveLocation. On success, if the edited message was sent by the bot, the edited Message is returned, otherwise True is returned.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EditMessageLiveLocation implements MethodObject {
	/**
	 * Required if inline_message_id is not specified. Unique identifier for the target chat or username of the target channel (in the format @channelusername)
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
	 * Required if inline_message_id is not specified. Identifier of the sent message
	 */
	@JsonProperty(value = "message_id\t", required = false)
	private String messageId;
	/**
	 * Required if chat_id and message_id are not specified. Identifier of the inline message
	 */
	@JsonProperty(value = "inline_message_id", required = false)
	private String inlineMessageId;
	/**
	 * A JSON-serialized object for a new inline keyboard.
	 * <p>
	 * InlineKeyboardMarkup
	 */
	@JsonProperty(value = "reply_markup", required = false)
	private Object replyMarkup;

	public static EditMessageLiveLocation create() {
		return new EditMessageLiveLocation();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "editMessageLiveLocation";
	}

	public EditMessageLiveLocation chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public EditMessageLiveLocation latitude(Float latitude) {
		this.latitude = latitude;
		return this;
	}

	public EditMessageLiveLocation longitude(Float longitude) {
		this.longitude = longitude;
		return this;
	}

	public EditMessageLiveLocation messageId(String messageId) {
		this.messageId = messageId;
		return this;
	}

	public EditMessageLiveLocation inlineMessageId(String inlineMessageId) {
		this.inlineMessageId = inlineMessageId;
		return this;
	}

	public EditMessageLiveLocation replyMarkup(Object replyMarkup) {
		this.replyMarkup = replyMarkup;
		return this;
	}
}
