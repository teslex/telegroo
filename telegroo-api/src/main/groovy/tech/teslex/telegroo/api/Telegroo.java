package tech.teslex.telegroo.api;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import tech.teslex.telegroo.api.context.MethodsContext;
import tech.teslex.telegroo.api.update.CommandUpdateHandler;
import tech.teslex.telegroo.api.update.MessageUpdateHandler;
import tech.teslex.telegroo.api.update.UpdateHandler;
import tech.teslex.telegroo.telegram.enums.UpdateType;
import tech.teslex.telegroo.telegram.types.update.Update;

public interface Telegroo {

	void start();

	void stop();

	void solveUpdate(Update update);


	MethodsContext<TelegramClient> getMainContext();


	void update(UpdateType type, @DelegatesTo(MethodsContext.class) Closure handler);

	void update(@DelegatesTo(MethodsContext.class) Closure handler);

	void command(String command, @DelegatesTo(MethodsContext.class) Closure handler);

	void message(String message, @DelegatesTo(MethodsContext.class) Closure handler);

	void message(@DelegatesTo(MethodsContext.class) Closure handler);


	void updateHandler(UpdateHandler handler);

	void commandUpdateHandler(CommandUpdateHandler handler);

	void messageUpdateHandler(MessageUpdateHandler handler);

	void middleware(Closure<Boolean> closure);
}