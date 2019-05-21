package tech.teslex.telegroo.telegram.enums

import groovy.transform.CompileStatic

@CompileStatic
enum UpdateType {

	UPDATE('update'), // custom

	MESSAGE('message'),
	EDITED_MESSAGE('editedMessage'),
	CHANNEL_POST('channelPost'),
	EDITED_CHANNEL_POST('editedChannelPost'),
	INLINE_QUERY('inlineQuery'),
	CHOSEN_INLINE_QUERY('chosenInlineResult'),
	CALLBACK_QUERY('callbackQuery'),
	SHIPPING_QUERY('shippingQuery'),
	PRE_CHECKOUT_QUERY('preCheckoutQuery'),
	POLL('poll')

	private String value

	String getValue() {
		return this.value
	}

	private UpdateType(String value) {
		this.value = value
	}

	static UpdateType fromString(String string) {
		values().find { it.value == string }
	}
}
