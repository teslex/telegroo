package tech.teslex.telegroo.api;

import groovy.lang.Closure;
import tech.teslex.telegroo.api.update.CommandUpdateHandler;
import tech.teslex.telegroo.api.update.MessageUpdateHandler;
import tech.teslex.telegroo.api.update.UpdateHandler;
import tech.teslex.telegroo.telegram.enums.UpdateType;
import tech.teslex.telegroo.telegram.types.update.Update;

public interface Telegroo {

	void start();

	void stop();

	void setLastUpdate(Update update);

	void solveUpdate(Update update);

	void on(UpdateType type, Closure handler);

	void onUpdate(Closure handler);

	void onCommand(String command, Closure handler);

	void onMessage(String message, Closure handler);

	void onUpdateHandler(UpdateHandler handler);

	void onCommandUpdateHandler(CommandUpdateHandler handler);

	void onMessageUpdateHandler(MessageUpdateHandler handler);

	void middleware(Closure<Boolean> closure);
}