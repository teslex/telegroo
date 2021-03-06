package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * restrictChatMember
 * Use this method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work and must have the appropriate admin rights. Pass True for all boolean parameters to lift restrictions from a user. Returns True on success.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestrictChatMember implements MethodObject {
	/**
	 * Unique identifier for the target chat or username of the target supergroup (in the format @supergroupusername)
	 */
	@JsonProperty(value = "chat_id", required = true)
	private Object chatId;
	/**
	 * Unique identifier of the target user
	 */
	@JsonProperty(value = "user_id", required = true)
	private Integer userId;
	/**
	 * Date when restrictions will be lifted for the user, unix time. If user is restricted for more than 366 days or less than 30 seconds from the current time, they are considered to be restricted forever
	 */
	@JsonProperty(value = "until_date", required = false)
	private Integer untilDate;
	/**
	 * Pass True, if the user can send text messages, contacts, locations and venues
	 */
	@JsonProperty(value = "can_send_messages", required = false)
	private Boolean canSendMessages;
	/**
	 * Pass True, if the user can send audios, documents, photos, videos, video notes and voice notes, implies can_send_messages
	 */
	@JsonProperty(value = "can_send_media_messages", required = false)
	private Boolean canSendMediaMessages;
	/**
	 * Pass True, if the user can send animations, games, stickers and use inline bots, implies can_send_media_messages
	 */
	@JsonProperty(value = "can_send_other_messages", required = false)
	private Boolean canSendOtherMessages;
	/**
	 * Pass True, if the user may add web page previews to their messages, implies can_send_media_messages
	 */
	@JsonProperty(value = "can_add_web_page_previews", required = false)
	private Boolean canAddWebPagePreviews;

	public static RestrictChatMember create() {
		return new RestrictChatMember();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "restrictChatMember";
	}

	public RestrictChatMember chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public RestrictChatMember userId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public RestrictChatMember untilDate(Integer untilDate) {
		this.untilDate = untilDate;
		return this;
	}

	public RestrictChatMember canSendMessages(Boolean canSendMessages) {
		this.canSendMessages = canSendMessages;
		return this;
	}

	public RestrictChatMember canSendMediaMessages(Boolean canSendMediaMessages) {
		this.canSendMediaMessages = canSendMediaMessages;
		return this;
	}

	public RestrictChatMember canSendOtherMessages(Boolean canSendOtherMessages) {
		this.canSendOtherMessages = canSendOtherMessages;
		return this;
	}

	public RestrictChatMember canAddWebPagePreviews(Boolean canAddWebPagePreviews) {
		this.canAddWebPagePreviews = canAddWebPagePreviews;
		return this;
	}
}
