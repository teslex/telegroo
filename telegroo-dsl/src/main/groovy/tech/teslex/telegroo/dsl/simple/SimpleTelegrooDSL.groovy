package tech.teslex.telegroo.dsl.simple

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Telegroo
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.dsl.api.CommandsDSL
import tech.teslex.telegroo.dsl.api.TelegrooDSL
import tech.teslex.telegroo.telegram.enums.UpdateType

@CompileStatic
class SimpleTelegrooDSL implements TelegrooDSL {

	private Telegroo telegroo

	SimpleTelegrooDSL(Telegroo telegroo) {
		this.telegroo = telegroo
	}

	@Override
	void update(UpdateType type, @DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.update(type, handler)
	}

	@Override
	void command(String command, @DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command(command, handler)
	}

	@Override
	void commands(@DelegatesTo(CommandsDSL.class) Closure closure) {
		SimpleCommandsDSL commandsDSL = new SimpleCommandsDSL(telegroo)
		closure.delegate = commandsDSL
		closure()
	}

	@Override
	void message(String message, @DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.message(message, handler)
	}

	@Override
	void update(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.update(handler)
	}

	@Override
	void message(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.message(handler)
	}

	@Override
	void editedMessage(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.update(UpdateType.EDITED_MESSAGE, handler)
	}

	@Override
	void channelPost(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.update(UpdateType.CHANNEL_POST, handler)
	}

	@Override
	void inlineQuery(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.update(UpdateType.INLINE_QUERY, handler)
	}

	@Override
	void chosenInlineResult(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.update(UpdateType.CHOSEN_INLINE_QUERY, handler)
	}

	@Override
	void callbackQuery(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.update(UpdateType.CALLBACK_QUERY, handler)
	}

	@Override
	void shippingQuery(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.update(UpdateType.SHIPPING_QUERY, handler)
	}

	@Override
	void preCheckoutQuery(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.update(UpdateType.PRE_CHECKOUT_QUERY, handler)
	}
}
