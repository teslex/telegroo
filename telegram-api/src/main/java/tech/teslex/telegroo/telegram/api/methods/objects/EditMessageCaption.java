package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup;

/**
 * editMessageCaption
 * Use this method to edit captions of messages sent by the bot or via the bot (for inline bots). On success, if edited message is sent by the bot, the edited Message is returned, otherwise True is returned.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EditMessageCaption implements MethodObject {
	/**
	 * Required if inline_message_id is not specified. Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@JsonProperty(value = "chat_id", required = false)
	private Object chatId;
	/**
	 * Required if inline_message_id is not specified. Identifier of the sent message
	 */
	@JsonProperty(value = "message_id", required = false)
	private Integer messageId;
	/**
	 * Required if chat_id and message_id are not specified. Identifier of the inline message
	 */
	@JsonProperty(value = "inline_message_id", required = false)
	private String inlineMessageId;
	/**
	 * New caption of the message
	 */
	@JsonProperty(required = false)
	private String caption;
	/**
	 * Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
	 */
	@JsonProperty(value = "parse_mode", required = false)
	private String parseMode;
	/**
	 * A JSON-serialized object for an inline keyboard.
	 */
	@JsonProperty(value = "reply_markup", required = false)
	private InlineKeyboardMarkup replyMarkup;

	public static EditMessageCaption create() {
		return new EditMessageCaption();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "editMessageCaption";
	}

	public EditMessageCaption chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public EditMessageCaption messageId(Integer messageId) {
		this.messageId = messageId;
		return this;
	}

	public EditMessageCaption inlineMessageId(String inlineMessageId) {
		this.inlineMessageId = inlineMessageId;
		return this;
	}

	public EditMessageCaption caption(String caption) {
		this.caption = caption;
		return this;
	}

	public EditMessageCaption parseMode(String parseMode) {
		this.parseMode = parseMode;
		return this;
	}

	public EditMessageCaption replyMarkup(InlineKeyboardMarkup replyMarkup) {
		this.replyMarkup = replyMarkup;
		return this;
	}
}
