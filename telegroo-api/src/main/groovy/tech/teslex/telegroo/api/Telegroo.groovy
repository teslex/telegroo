package tech.teslex.telegroo.api

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.api.update.CommandUpdateHandler
import tech.teslex.telegroo.api.update.MessageUpdateHandler
import tech.teslex.telegroo.api.update.UpdateHandler
import tech.teslex.telegroo.telegram.enums.UpdateType
import tech.teslex.telegroo.telegram.types.update.Update

@CompileStatic
interface Telegroo extends MethodsContext {

	void start();

	void stop();


	void setLastUpdate(Update update);

	void setJacksonObjectMapper(ObjectMapper objectMapper);


	void solveUpdate(Update update);


	void on(UpdateType type, @DelegatesTo(MethodsContext) Closure handler);

	void onUpdate(@DelegatesTo(MethodsContext) Closure handler);

	void onCommand(String command, @DelegatesTo(MethodsContext) Closure handler);

	void onMessage(String message, @DelegatesTo(MethodsContext) Closure handler);


	void onUpdateHandler(UpdateHandler handler);

	void onCommandUpdateHandler(CommandUpdateHandler handler);

	void onMessageUpdateHandler(MessageUpdateHandler handler);


	void middleware(Closure<Boolean> closure);
}
