/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * © 2019 TesLex
 */

package tech.teslex.telegroo.simple

import groovy.transform.CompileStatic
import groovy.transform.SelfType
import tech.teslex.telegroo.api.Telegroo
import tech.teslex.telegroo.api.context.CommandContext
import tech.teslex.telegroo.api.context.MessageContext
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.api.update.CallbackQueryUpdateHandler
import tech.teslex.telegroo.api.update.CommandPatternUpdateHandler
import tech.teslex.telegroo.api.update.MessagePatternUpdateHandler
import tech.teslex.telegroo.api.update.UpdateHandler
import tech.teslex.telegroo.simple.update.closure.*
import tech.teslex.telegroo.telegram.enums.UpdateType

import java.util.regex.Pattern

@CompileStatic
@SelfType(SimpleTelegroo)
trait SimpleTelegrooTrait implements Telegroo {

	@Override
	void on(UpdateType updateType, @DelegatesTo(MethodsContext) Closure handler) {
		if (!handlers.containsKey(updateType)) handlers.put(updateType, new LinkedList())
		handlers[updateType] << new SimpleClosureUpdateHandler(updateType, handler)
	}

	@Override
	void on(@DelegatesTo(MethodsContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.UPDATE)) handlers.put(UpdateType.UPDATE, new LinkedList())
		handlers[UpdateType.UPDATE] << new SimpleClosureUpdateHandler(handler)
	}

	@Override
	void command(Pattern command, @DelegatesTo(CommandContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureCommandPatternUpdateHandler(command, handler)
	}

	@Override
	void command(Pattern command, Pattern argsPattern, @DelegatesTo(CommandContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureCommandPatternUpdateHandler(command, argsPattern, handler)
	}

	@Override
	void command(String command, @DelegatesTo(CommandContext.class) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureCommandPatternUpdateHandler(Pattern.compile(command), handler)
	}

	@Override
	void command(String command, Pattern argsPattern, @DelegatesTo(CommandContext.class) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureCommandPatternUpdateHandler(Pattern.compile(command), argsPattern, handler)
	}

	@Override
	void command(String command, String argsPattern, @DelegatesTo(CommandContext.class) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureCommandPatternUpdateHandler(Pattern.compile(command), Pattern.compile(argsPattern), handler)
	}

	@Override
	void message(Pattern message, @DelegatesTo(MessageContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureMessagePatternUpdateHandler(message, handler)
	}

	@Override
	void message(String message, @DelegatesTo(MessageContext.class) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureMessagePatternUpdateHandler(Pattern.compile(message), handler)
	}

	@Override
	void message(@DelegatesTo(MessageContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureUpdateHandler(UpdateType.MESSAGE, handler)
	}

	@Override
	void entity(String entity, @DelegatesTo(MethodsContext.class) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureEntityUpdateHandler(entity, handler)
	}

	@Override
	void callbackQuery(String callbackData, @DelegatesTo(MethodsContext.class) Closure handler) {
		if (!handlers.containsKey(UpdateType.CALLBACK_QUERY)) handlers.put(UpdateType.CALLBACK_QUERY, new LinkedList())
		handlers[UpdateType.CALLBACK_QUERY] << new SimpleClosureCallbackQueryUpdateHandler(callbackData, handler)
	}


	@Override
	void updateHandler(UpdateHandler handler) {
		if (!handlers.containsKey(UpdateType.UPDATE)) handlers.put(UpdateType.UPDATE, new LinkedList())
		handlers[UpdateType.UPDATE] << handler
	}

	@Override
	void commandUpdateHandler(CommandPatternUpdateHandler handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << handler
	}

	@Override
	void messageUpdateHandler(MessagePatternUpdateHandler handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << handler
	}

	@Override
	void callbackQueryUpdateHandler(CallbackQueryUpdateHandler handler) {
		if (!handlers.containsKey(UpdateType.CALLBACK_QUERY)) handlers.put(UpdateType.CALLBACK_QUERY, new LinkedList())
		handlers[UpdateType.CALLBACK_QUERY] << handler
	}

	@Override
	void middleware(Closure<Boolean> closure) {
		middlewareList.add(closure)
	}
}