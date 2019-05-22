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
import tech.teslex.telegroo.api.context.CommandContext;
import tech.teslex.telegroo.api.context.MessageContext;
import tech.teslex.telegroo.api.context.MethodsContext;
import tech.teslex.telegroo.api.update.CommandPatternUpdateHandler;
import tech.teslex.telegroo.api.update.MessagePatternUpdateHandler;
import tech.teslex.telegroo.api.update.UpdateHandler;
import tech.teslex.telegroo.telegram.enums.UpdateType;
import tech.teslex.telegroo.telegram.types.update.Update;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Telegroo!!!
 */
public interface Telegroo {

	void start();

	void stop();

	void solveUpdates(List<Update> update);


	MethodsContext<TelegramClient> getMainContext();

	void update(UpdateType type, @DelegatesTo(MethodsContext.class) Closure handler);

	void update(@DelegatesTo(MethodsContext.class) Closure handler);

	void command(Pattern command, @DelegatesTo(CommandContext.class) Closure handler);

	void command(Pattern command, Pattern argsPattern, @DelegatesTo(CommandContext.class) Closure handler);

	void command(String command, @DelegatesTo(CommandContext.class) Closure handler);

	void command(String command, Pattern argsPattern, @DelegatesTo(CommandContext.class) Closure handler);

	void command(String command, String argsPattern, @DelegatesTo(CommandContext.class) Closure handler);

	void message(Pattern message, @DelegatesTo(MessageContext.class) Closure handler);

	void message(String message, @DelegatesTo(MessageContext.class) Closure handler);

	void message(@DelegatesTo(MessageContext.class) Closure handler);

	void entity(String entity, @DelegatesTo(MethodsContext.class) Closure handler);

	void entities(List<String> entities, @DelegatesTo(MethodsContext.class) Closure handler);

	void callbackQuery(String callbackData, @DelegatesTo(MethodsContext.class) Closure closure);


	void updateHandler(UpdateHandler handler);

	void commandUpdateHandler(CommandPatternUpdateHandler handler);

	void messageUpdateHandler(MessagePatternUpdateHandler handler);

	void middleware(Closure<Boolean> closure);
}