package tech.teslex.telegroo.simple

import groovy.transform.CompileStatic
import groovy.transform.SelfType
import tech.teslex.telegroo.api.Telegroo
import tech.teslex.telegroo.api.context.CommandContext
import tech.teslex.telegroo.api.context.MessageContext
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.api.update.CommandPatternUpdateHandler
import tech.teslex.telegroo.api.update.MessagePatternUpdateHandler
import tech.teslex.telegroo.api.update.UpdateHandler
import tech.teslex.telegroo.simple.update.closure.SimpleClosureCommandPatternUpdateHandler
import tech.teslex.telegroo.simple.update.closure.SimpleClosureEntitiesUpdateHandler
import tech.teslex.telegroo.simple.update.closure.SimpleClosureMessagePatternUpdateHandler
import tech.teslex.telegroo.simple.update.closure.SimpleClosureUpdateHandler
import tech.teslex.telegroo.telegram.enums.UpdateType

import java.util.regex.Pattern

@CompileStatic
@SelfType(SimpleTelegroo)
trait SimpleTelegrooTrait implements Telegroo {

	@Override
	void update(UpdateType updateType, @DelegatesTo(MethodsContext) Closure handler) {
		if (!handlers.containsKey(updateType)) handlers.put(updateType, [])
		handlers[updateType] << new SimpleClosureUpdateHandler(updateType, handler)
	}

	@Override
	void update(@DelegatesTo(MethodsContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.UPDATE)) handlers.put(UpdateType.UPDATE, [])
		handlers[UpdateType.UPDATE] << new SimpleClosureUpdateHandler(handler)
	}

	@Override
	void command(Pattern command, @DelegatesTo(CommandContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, [])
		handlers[UpdateType.MESSAGE] << new SimpleClosureCommandPatternUpdateHandler(command, handler)
	}

	@Override
	void command(Pattern command, Pattern argsPattern, @DelegatesTo(CommandContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, [])
		handlers[UpdateType.MESSAGE] << new SimpleClosureCommandPatternUpdateHandler(command, argsPattern, handler)
	}

	@Override
	void command(String command, @DelegatesTo(CommandContext.class) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, [])
		handlers[UpdateType.MESSAGE] << new SimpleClosureCommandPatternUpdateHandler(Pattern.compile(command), handler)
	}

	@Override
	void command(String command, Pattern argsPattern, @DelegatesTo(CommandContext.class) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, [])
		handlers[UpdateType.MESSAGE] << new SimpleClosureCommandPatternUpdateHandler(Pattern.compile(command), argsPattern, handler)
	}

	@Override
	void message(Pattern message, @DelegatesTo(MessageContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, [])
		handlers[UpdateType.MESSAGE] << new SimpleClosureMessagePatternUpdateHandler(message, handler)
	}

	@Override
	void message(String message, @DelegatesTo(MessageContext.class) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, [])
		handlers[UpdateType.MESSAGE] << new SimpleClosureMessagePatternUpdateHandler(Pattern.compile(message), handler)
	}

	@Override
	void message(@DelegatesTo(MessageContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, [])
		handlers[UpdateType.MESSAGE] << new SimpleClosureUpdateHandler(UpdateType.MESSAGE, handler)
	}

	@Override
	void updateHandler(UpdateHandler handler) {
		if (!handlers.containsKey(UpdateType.UPDATE)) handlers.put(UpdateType.UPDATE, [])
		handlers[UpdateType.UPDATE] << handler
	}

	@Override
	void commandUpdateHandler(CommandPatternUpdateHandler handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, [])
		handlers[UpdateType.MESSAGE] << handler
	}

	@Override
	void messageUpdateHandler(MessagePatternUpdateHandler handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, [])
		handlers[UpdateType.MESSAGE] << handler
	}

	@Override
	void entity(String entity, @DelegatesTo(MethodsContext.class) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, [])
		handlers[UpdateType.MESSAGE] << new SimpleClosureEntitiesUpdateHandler([entity], handler)
	}

	@Override
	void entities(List<String> entities, @DelegatesTo(MethodsContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, [])
		handlers[UpdateType.MESSAGE] << new SimpleClosureEntitiesUpdateHandler(entities, handler)
	}

	@Override
	void middleware(Closure<Boolean> closure) {
		middlewareList.add(closure)
	}
}
