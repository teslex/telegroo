package tech.teslex.telegroo.api;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import tech.teslex.telegroo.api.context.MethodsContext;
import tech.teslex.telegroo.api.update.CommandUpdateHandler;
import tech.teslex.telegroo.api.update.MessageUpdateHandler;
import tech.teslex.telegroo.api.update.UpdateHandler;
import tech.teslex.telegroo.telegram.enums.UpdateType;
import tech.teslex.telegroo.telegram.types.update.Update;

public interface Telegroo<T> extends MethodsContext<T> {

	void start();

	void stop();

	void setLastUpdate(Update update);

	void solveUpdate(Update update);

	String getDefaultCommandSymbol();


	void on(UpdateType type, @DelegatesTo(MethodsContext.class) Closure handler);

	void onUpdate(@DelegatesTo(MethodsContext.class) Closure handler);

	void onCommand(String command, @DelegatesTo(MethodsContext.class) Closure handler);

	void onMessage(String message, @DelegatesTo(MethodsContext.class) Closure handler);

	void onMessage(@DelegatesTo(MethodsContext.class) Closure handler);


	void onUpdateHandler(UpdateHandler handler);

	void onCommandUpdateHandler(CommandUpdateHandler handler);

	void onMessageUpdateHandler(MessageUpdateHandler handler);

	void middleware(Closure<Boolean> closure);
}