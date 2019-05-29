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
import tech.teslex.telegroo.api.update.CallbackQueryUpdateListener
import tech.teslex.telegroo.api.update.CommandUpdateListener
import tech.teslex.telegroo.api.update.MessagePatternUpdateListener
import tech.teslex.telegroo.api.update.UpdateListener
import tech.teslex.telegroo.simple.update.closure.*
import tech.teslex.telegroo.telegram.enums.UpdateType

import java.util.regex.Pattern

@CompileStatic
@SelfType(SimpleTelegroo)
trait SimpleTelegrooTrait implements Telegroo {

	@Override
	void on(UpdateType updateType, @DelegatesTo(MethodsContext) Closure handler) {
		if (!handlers.containsKey(updateType)) handlers.put(updateType, new LinkedList())
		handlers[updateType] << new SimpleClosureUpdateListener(updateType, handler)
	}

	@Override
	void on(@DelegatesTo(MethodsContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.UPDATE)) handlers.put(UpdateType.UPDATE, new LinkedList())
		handlers[UpdateType.UPDATE] << new SimpleClosureUpdateListener(handler)
	}

	@Override
	void command(Pattern command, @DelegatesTo(CommandContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureCommandUpdateListener(command, handler)
	}

	@Override
	void command(Pattern command, Pattern argsPattern, @DelegatesTo(CommandContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureCommandUpdateListener(command, argsPattern, handler)
	}

	@Override
	void command(String command, @DelegatesTo(CommandContext.class) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureCommandUpdateListener(Pattern.compile(command), handler)
	}

	@Override
	void command(String command, Pattern argsPattern, @DelegatesTo(CommandContext.class) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureCommandUpdateListener(Pattern.compile(command), argsPattern, handler)
	}

	@Override
	void command(String command, String argsPattern, @DelegatesTo(CommandContext.class) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureCommandUpdateListener(Pattern.compile(command), Pattern.compile(argsPattern), handler)
	}

	@Override
	void message(Pattern message, @DelegatesTo(MessageContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureMessagePatternUpdateListener(message, handler)
	}

	@Override
	void message(String message, @DelegatesTo(MessageContext.class) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureMessagePatternUpdateListener(Pattern.compile(message), handler)
	}

	@Override
	void message(@DelegatesTo(MessageContext) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureUpdateListener(UpdateType.MESSAGE, handler)
	}

	@Override
	void entity(String entity, @DelegatesTo(MethodsContext.class) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureEntityUpdateListener(entity, handler)
	}

	@Override
	void callbackQuery(String callbackData, @DelegatesTo(MethodsContext.class) Closure handler) {
		if (!handlers.containsKey(UpdateType.CALLBACK_QUERY)) handlers.put(UpdateType.CALLBACK_QUERY, new LinkedList())
		handlers[UpdateType.CALLBACK_QUERY] << new SimpleClosureCallbackQueryUpdateListener(callbackData, handler)
	}


	@Override
	void updateListener(UpdateListener handler) {
		if (!handlers.containsKey(UpdateType.UPDATE)) handlers.put(UpdateType.UPDATE, new LinkedList())
		handlers[UpdateType.UPDATE] << handler
	}

	@Override
	void commandUpdateListener(CommandUpdateListener handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << handler
	}

	@Override
	void messageUpdateListener(MessagePatternUpdateListener handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << handler
	}

	@Override
	void callbackQueryUpdateListener(CallbackQueryUpdateListener handler) {
		if (!handlers.containsKey(UpdateType.CALLBACK_QUERY)) handlers.put(UpdateType.CALLBACK_QUERY, new LinkedList())
		handlers[UpdateType.CALLBACK_QUERY] << handler
	}

	@Override
	void middleware(Closure<Boolean> closure) {
		middlewareList.add(closure)
	}
}