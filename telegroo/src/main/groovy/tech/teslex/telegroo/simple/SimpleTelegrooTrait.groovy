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
import groovy.transform.NamedParam
import groovy.transform.NamedVariant
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
import tech.teslex.telegroo.telegram.api.TelegramErrorException
import tech.teslex.telegroo.telegram.enums.UpdateType

import java.util.function.Consumer
import java.util.regex.Pattern

@CompileStatic
@SelfType(SimpleTelegroo)
trait SimpleTelegrooTrait implements Telegroo {

	@Override
	@NamedVariant
	void on(@NamedParam UpdateType updateType, @DelegatesTo(value = MethodsContext, strategy = Closure.DELEGATE_FIRST) Closure handler) {
		if (!handlers.containsKey(updateType)) handlers.put(updateType, new LinkedList())
		handlers[updateType] << new SimpleClosureUpdateListener(updateType, handler)
	}

	@Override
	@NamedVariant
	void on(@NamedParam UpdateType updateType, @NamedParam Consumer<TelegramErrorException> error, @DelegatesTo(value = MethodsContext, strategy = Closure.DELEGATE_FIRST) Closure handler) {
		if (!handlers.containsKey(updateType)) handlers.put(updateType, new LinkedList())
		handlers[updateType] << new SimpleClosureUpdateListener(updateType, handler)
	}

	@Override
	void on(@DelegatesTo(value = MethodsContext, strategy = Closure.DELEGATE_FIRST) Closure handler) {
		if (!handlers.containsKey(UpdateType.UPDATE)) handlers.put(UpdateType.UPDATE, new LinkedList())
		handlers[UpdateType.UPDATE] << new SimpleClosureUpdateListener(handler)
	}

	@Override
	@NamedVariant
	void command(@NamedParam Pattern command, @DelegatesTo(value = CommandContext, strategy = Closure.DELEGATE_FIRST) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureCommandUpdateListener(command, handler)
	}

	@Override
	@NamedVariant
	void command(@NamedParam Pattern command, @NamedParam Pattern argsPattern, @DelegatesTo(value = CommandContext, strategy = Closure.DELEGATE_FIRST) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureCommandUpdateListener(command, argsPattern, handler)
	}

	@Override
	@NamedVariant
	void command(@NamedParam String command, @DelegatesTo(value = CommandContext.class, strategy = Closure.DELEGATE_FIRST) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureCommandUpdateListener(Pattern.compile(command), handler)
	}

	@Override
	@NamedVariant
	void command(@NamedParam String command, @NamedParam Pattern argsPattern, @DelegatesTo(value = CommandContext.class, strategy = Closure.DELEGATE_FIRST) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureCommandUpdateListener(Pattern.compile(command), argsPattern, handler)
	}

	@Override
	@NamedVariant
	void command(@NamedParam String command, @NamedParam String argsPattern, @DelegatesTo(value = CommandContext.class, strategy = Closure.DELEGATE_FIRST) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureCommandUpdateListener(Pattern.compile(command), Pattern.compile(argsPattern), handler)
	}

	@Override
	@NamedVariant
	void message(@NamedParam Pattern message, @DelegatesTo(value = MessageContext, strategy = Closure.DELEGATE_FIRST) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureMessagePatternUpdateListener(message, handler)
	}

	@Override
	@NamedVariant
	void message(@NamedParam String message, @DelegatesTo(value = MessageContext.class, strategy = Closure.DELEGATE_FIRST) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureMessagePatternUpdateListener(Pattern.compile(message), handler)
	}

	@Override
	void message(@DelegatesTo(value = MessageContext, strategy = Closure.DELEGATE_FIRST) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureUpdateListener(UpdateType.MESSAGE, handler)
	}

	@Override
	@NamedVariant
	void entity(@NamedParam String entity, @DelegatesTo(value = MethodsContext, strategy = Closure.DELEGATE_FIRST) Closure handler) {
		if (!handlers.containsKey(UpdateType.MESSAGE)) handlers.put(UpdateType.MESSAGE, new LinkedList())
		handlers[UpdateType.MESSAGE] << new SimpleClosureEntityUpdateListener(entity, handler)
	}

	@Override
	@NamedVariant
	void callbackQuery(@NamedParam String callbackData, @DelegatesTo(value = MethodsContext, strategy = Closure.DELEGATE_FIRST) Closure handler) {
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