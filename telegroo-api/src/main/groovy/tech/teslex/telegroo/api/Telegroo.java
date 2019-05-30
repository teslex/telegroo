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

package tech.teslex.telegroo.api;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedParam;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.api.context.CommandContext;
import tech.teslex.telegroo.api.context.MessageContext;
import tech.teslex.telegroo.api.context.MethodsContext;
import tech.teslex.telegroo.api.update.CallbackQueryUpdateListener;
import tech.teslex.telegroo.api.update.CommandUpdateListener;
import tech.teslex.telegroo.api.update.MessagePatternUpdateListener;
import tech.teslex.telegroo.api.update.UpdateListener;
import tech.teslex.telegroo.telegram.api.TelegramErrorException;
import tech.teslex.telegroo.telegram.api.types.update.Update;
import tech.teslex.telegroo.telegram.enums.UpdateType;

import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Pattern;

/**
 * Telegroo!!!
 */
public interface Telegroo {

	void start();

	void stop();

	void solveUpdates(List<Update> update);


	MethodsContext<TelegramClient> getMainContext();

	@NamedVariant
	void on(@NamedParam UpdateType type, @DelegatesTo(value = MethodsContext.class, strategy = Closure.DELEGATE_FIRST) Closure handler);

	@NamedVariant
	void on(@NamedParam UpdateType type, @NamedParam Consumer<TelegramErrorException> error, @DelegatesTo(value = MethodsContext.class, strategy = Closure.DELEGATE_FIRST) Closure handler);

	void on(@DelegatesTo(value = MethodsContext.class, strategy = Closure.DELEGATE_FIRST) Closure handler);

	@NamedVariant
	void command(@NamedParam Pattern command, @DelegatesTo(value = CommandContext.class, strategy = Closure.DELEGATE_FIRST) Closure handler);

	@NamedVariant
	void command(@NamedParam Pattern command, @NamedParam Pattern argsPattern, @DelegatesTo(value = CommandContext.class, strategy = Closure.DELEGATE_FIRST) Closure handler);

	@NamedVariant
	void command(@NamedParam String command, @DelegatesTo(value = CommandContext.class, strategy = Closure.DELEGATE_FIRST) Closure handler);

	@NamedVariant
	void command(@NamedParam String command, @NamedParam Pattern argsPattern, @DelegatesTo(value = CommandContext.class, strategy = Closure.DELEGATE_FIRST) Closure handler);

	@NamedVariant
	void command(@NamedParam String command, @NamedParam String argsPattern, @DelegatesTo(value = CommandContext.class, strategy = Closure.DELEGATE_FIRST) Closure handler);

	@NamedVariant
	void message(@NamedParam Pattern message, @DelegatesTo(value = MessageContext.class, strategy = Closure.DELEGATE_FIRST) Closure handler);

	@NamedVariant
	void message(@NamedParam String message, @DelegatesTo(value = MessageContext.class, strategy = Closure.DELEGATE_FIRST) Closure handler);

	@NamedVariant
	void message(@DelegatesTo(value = MessageContext.class, strategy = Closure.DELEGATE_FIRST) Closure handler);

	@NamedVariant
	void entity(@NamedParam String entity, @DelegatesTo(value = MethodsContext.class, strategy = Closure.DELEGATE_FIRST) Closure handler);

	@NamedVariant
	void callbackQuery(@NamedParam String callbackData, @DelegatesTo(value = MethodsContext.class, strategy = Closure.DELEGATE_FIRST) Closure closure);


	void updateListener(UpdateListener handler);

	void commandUpdateListener(CommandUpdateListener handler);

	void messageUpdateListener(MessagePatternUpdateListener handler);

	void callbackQueryUpdateListener(CallbackQueryUpdateListener handler);

	void middleware(Closure<Boolean> closure);
}