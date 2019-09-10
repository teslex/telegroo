package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageEntity {
	/**
	 * Type of the entity. Can be mention (@username), hashtag, cashtag, bot_command, url, email, phone_number, bold (bold text), italic (italic text), code (monowidth string), pre (monowidth block), text_link (for clickable text URLs), text_mention (for users without usernames)
	 *
	 * @see Entity
	 */
	private String type;
	/**
	 * Offset in UTF-16 code units to the start of the entity
	 */
	private Integer offset;
	/**
	 * Length of the entity in UTF-16 code units
	 */
	private Integer length;
	/**
	 * Optional. For “text_link” only, url that will be opened after user taps on the text
	 */
	@JsonProperty(required = false)
	private String url;
	/**
	 * Optional. For “text_mention” only, the mentioned user
	 */
	@JsonProperty(required = false)
	private User user;

	public enum Entity {
		MENTION("mention"),
		HASHTAG("hashtag"),
		CASHTAG("cashtag"),
		BOT_COMMAND("bot_command"),
		URL("url"),
		EMAIL("email"),
		PHONE_NUMBER("phone_number"),
		BOLD("bold"),
		ITALIC("italic"),
		CODE("code"),
		PRE("pre"),
		TEXT_LINK("text_link"),
		TEXT_MENTION("text_mention");

		private final String code;

		Entity(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}
	}
}
