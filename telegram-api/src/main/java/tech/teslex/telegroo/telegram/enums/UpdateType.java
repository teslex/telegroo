package tech.teslex.telegroo.telegram.enums;

import java.util.Arrays;

public enum UpdateType {

	/**
	 * Used when update type is unknown
	 */
	UPDATE("update"),
	MESSAGE("message"),
	EDITED_MESSAGE("edited_message"),
	CHANNEL_POST("channel_post"),
	EDITED_CHANNEL_POST("edited_channel_post"),
	INLINE_QUERY("inline_query"),
	CHOSEN_INLINE_QUERY("chosen_inline_result"),
	CALLBACK_QUERY("callback_query"),
	SHIPPING_QUERY("shipping_query"),
	PRE_CHECKOUT_QUERY("pre_checkout_query"),
	POLL("poll");

	private String value;

	UpdateType(String value) {
		this.value = value;
	}

	public static UpdateType fromString(final String string) {
		return Arrays.stream(values())
				.filter(updateType -> updateType.getValue().equals(string))
				.findFirst()
				.orElseThrow(RuntimeException::new);
	}

	public String getValue() {
		return this.value;
	}
}
