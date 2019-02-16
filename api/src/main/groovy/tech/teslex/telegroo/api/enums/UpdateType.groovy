package tech.teslex.telegroo.api.enums

enum UpdateType {

	UPDATE('update'),

	MESSAGE('message'),
	EDITED_MESSAGE('edited_message'),
	CHANNEL_POST('channel_post'),
	EDITED_CHANNEL_POST('edited_channel_post'),
	INLINE_QUERY('inline_query'),
	CHOSEN_INLINE_QUERY('chosen_inline_result'),
	CALLBACK_QUERY('callback_query'),
	SHIPPING_QUERY('shipping_query'),
	PRE_CHECKOUT_QUERY('pre_checkout_query')

	private String type

	String getType() {
		return this.type
	}

	private UpdateType(String type) {
		this.type = type
	}
}
