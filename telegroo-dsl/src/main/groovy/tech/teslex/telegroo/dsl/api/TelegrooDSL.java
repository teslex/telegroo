package tech.teslex.telegroo.dsl.api;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import tech.teslex.telegroo.api.context.MethodsContext;
import tech.teslex.telegroo.dsl.api.CommandsDSL;
import tech.teslex.telegroo.telegram.enums.UpdateType;

public interface TelegrooDSL {

	void update(UpdateType type, @DelegatesTo(MethodsContext.class) Closure handler);

	void command(String command, @DelegatesTo(MethodsContext.class) Closure handler);

	void commands(@DelegatesTo(CommandsDSL.class) Closure closure);

	void message(String message, @DelegatesTo(MethodsContext.class) Closure handler);


	void update(@DelegatesTo(MethodsContext.class) Closure handler);

	void message(@DelegatesTo(MethodsContext.class) Closure handler);

	void editedMessage(@DelegatesTo(MethodsContext.class) Closure handler);

	void channelPost(@DelegatesTo(MethodsContext.class) Closure handler);

	void inlineQuery(@DelegatesTo(MethodsContext.class) Closure handler);

	void chosenInlineResult(@DelegatesTo(MethodsContext.class) Closure handler);

	void callbackQuery(@DelegatesTo(MethodsContext.class) Closure handler);

	void shippingQuery(@DelegatesTo(MethodsContext.class) Closure handler);

	void preCheckoutQuery(@DelegatesTo(MethodsContext.class) Closure handler);
}
