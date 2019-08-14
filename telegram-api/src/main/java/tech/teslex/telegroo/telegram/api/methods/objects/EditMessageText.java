package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup;

/**
 * editMessageText
 * Use this method to edit text and game messages sent by the bot or via the bot (for inline bots). On success, if edited message is sent by the bot, the edited Message is returned, otherwise True is returned.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EditMessageText implements MethodObject {
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
	 * New text of the message
	 */
	@JsonProperty(required = true)
	private String text;
	/**
	 * Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in your bot's message.
	 */
	@JsonProperty(value = "parse_mode", required = false)
	private String parseMode;
	/**
	 * Disables link previews for links in this message
	 */
	@JsonProperty(value = "disable_web_page_preview", required = false)
	private Boolean disableWebPagePreview;
	/**
	 * A JSON-serialized object for an inline keyboard.
	 */
	@JsonProperty(value = "reply_markup", required = false)
	private InlineKeyboardMarkup replyMarkup;

	public static EditMessageText create() {
		return new EditMessageText();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "editMessageText";
	}

	public EditMessageText chatId(Object chatId) {
		this.chatId = chatId;
		return this;
	}

	public EditMessageText messageId(Integer messageId) {
		this.messageId = messageId;
		return this;
	}

	public EditMessageText inlineMessageId(String inlineMessageId) {
		this.inlineMessageId = inlineMessageId;
		return this;
	}

	public EditMessageText text(String text) {
		this.text = text;
		return this;
	}

	public EditMessageText parseMode(String parseMode) {
		this.parseMode = parseMode;
		return this;
	}

	public EditMessageText disableWebPagePreview(Boolean disableWebPagePreview) {
		this.disableWebPagePreview = disableWebPagePreview;
		return this;
	}

	public EditMessageText replyMarkup(InlineKeyboardMarkup replyMarkup) {
		this.replyMarkup = replyMarkup;
		return this;
	}
}
