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
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.context.CommandContext;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.api.context.MessageContext;
import tech.teslex.telegroo.api.update.UpdateListener;
import tech.teslex.telegroo.telegram.api.types.update.Update;

import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Telegroo!!!
 */
public interface Telegroo {

	TelegramClient getTelegramClient();

	Context getMainContext();

	/**
	 * Handles updates. Returns last handled update.
	 *
	 * @param updates iterable of update
	 * @return last handled update
	 */
	Optional<Update> handleUpdates(Iterable<Update> updates);

	@NamedVariant
	void listen(@DelegatesTo(value = Context.class, strategy = Closure.DELEGATE_FIRST) UpdateListener<Context> listener);

	@NamedVariant
	void listenMessage(Pattern pattern, @DelegatesTo(value = Context.class, strategy = Closure.DELEGATE_FIRST) UpdateListener<MessageContext> listener);

	@NamedVariant
	void listenCommand(Pattern pattern, @DelegatesTo(value = Context.class, strategy = Closure.DELEGATE_FIRST) UpdateListener<CommandContext> listener);

	@NamedVariant
	default void listenMessage(String pattern, @DelegatesTo(value = Context.class, strategy = Closure.DELEGATE_FIRST) UpdateListener<MessageContext> listener) {
		listenMessage(Pattern.compile(pattern), listener);
	}

	@NamedVariant
	default void listenCommand(String pattern, @DelegatesTo(value = Context.class, strategy = Closure.DELEGATE_FIRST) UpdateListener<CommandContext> listener) {
		listenCommand(Pattern.compile(pattern), listener);
	}
}