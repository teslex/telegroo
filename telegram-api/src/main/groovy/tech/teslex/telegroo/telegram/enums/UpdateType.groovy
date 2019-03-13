package tech.teslex.telegroo.telegram.enums

import groovy.transform.CompileStatic

@CompileStatic
enum UpdateType {

	UPDATE('update'),

	MESSAGE('message'),
	EDITED_MESSAGE('editedMessage'),
	CHANNEL_POST('channelPost'),
	EDITED_CHANNEL_POST('editedChannelPost'),
	INLINE_QUERY('inlineQuery'),
	CHOSEN_INLINE_QUERY('chosenInlineResult'),
	CALLBACK_QUERY('callbackQuery'),
	SHIPPING_QUERY('shippingQuery'),
	PRE_CHECKOUT_QUERY('preCheckoutQuery')

	private String type

	String getType() {
		return this.type
	}

	private UpdateType(String type) {
		this.type = type
	}

	static UpdateType fromString(String string) {
		values().find { it.type == string }
	}
}
