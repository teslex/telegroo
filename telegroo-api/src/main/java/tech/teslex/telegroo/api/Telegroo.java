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

import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.context.CommandContext;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.api.context.MessageContext;
import tech.teslex.telegroo.api.methods.defaults.Methods;
import tech.teslex.telegroo.api.update.CommandUpdateListener;
import tech.teslex.telegroo.api.update.MessagePatternUpdateListener;
import tech.teslex.telegroo.api.update.UpdateListener;
import tech.teslex.telegroo.telegram.api.types.update.Update;

import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Telegroo!!!
 */
public interface Telegroo {

	/**
	 * Returns telegram client implementation
	 *
	 * @return telegram client
	 */
	TelegramClient getTelegramClient();

	/**
	 * Returns main context.
	 *
	 * @return context instance
	 */
	Context getMainContext();

	/**
	 * Handles updates. Returns last handled update.
	 *
	 * @param updates iterable of update
	 * @return last handled update
	 */
	Optional<Update> handleUpdates(Iterable<Update> updates);

	/**
	 * Returns methods for main context.
	 *
	 * @return methods
	 */
	Methods methods();

	/**
	 * Adds updates listener.
	 *
	 * @param listener updates listener
	 */
	void listen(UpdateListener<Context> listener);

	/**
	 * Adds messages listener.
	 *
	 * @param pattern  message pattern
	 * @param listener update listener with {@link MessageContext}
	 * @see MessageContext
	 * @see tech.teslex.telegroo.api.update.MessagePatternUpdateListener
	 */
	void listenMessage(Pattern pattern, UpdateListener<MessageContext> listener);

	/**
	 * Adds messages listener.
	 *
	 * @param listener messages listener
	 * @see MessageContext
	 * @see tech.teslex.telegroo.api.update.MessagePatternUpdateListener
	 */
	void listenMessage(MessagePatternUpdateListener<MessageContext> listener);

	/**
	 * Adds messages listener.
	 *
	 * @param pattern  message pattern as string
	 * @param listener update listener with {@link MessageContext}
	 * @see MessageContext
	 * @see tech.teslex.telegroo.api.update.MessagePatternUpdateListener
	 */
	default void listenMessage(String pattern, UpdateListener<MessageContext> listener) {
		listenMessage(Pattern.compile(pattern), listener);
	}

	/**
	 * Adds commands listener.
	 *
	 * @param pattern  command pattern
	 * @param listener update listener with {@link CommandContext}
	 * @see CommandContext
	 * @see tech.teslex.telegroo.api.update.CommandUpdateListener
	 */
	void listenCommand(Pattern pattern, UpdateListener<CommandContext> listener);

	/**
	 * Adds commands listener with args.
	 *
	 * @param pattern  command pattern
	 * @param args     command arguments pattern
	 * @param listener update listener with {@link CommandContext}
	 * @see CommandContext
	 * @see tech.teslex.telegroo.api.update.CommandUpdateListener
	 */
	void listenCommand(Pattern pattern, Pattern args, UpdateListener<CommandContext> listener);

	/**
	 * Adds commands listener.
	 *
	 * @param listener command listener
	 * @see CommandContext
	 * @see tech.teslex.telegroo.api.update.CommandUpdateListener
	 */
	void listenCommand(CommandUpdateListener<CommandContext> listener);

	/**
	 * Adds commands listener.
	 *
	 * @param pattern  command pattern as string
	 * @param listener update listener with {@link CommandContext}
	 * @see CommandContext
	 * @see tech.teslex.telegroo.api.update.CommandUpdateListener
	 */
	default void listenCommand(String pattern, UpdateListener<CommandContext> listener) {
		listenCommand(Pattern.compile(pattern), listener);
	}

	/**
	 * Adds commands listener with args.
	 *
	 * @param pattern  command pattern as string
	 * @param args     command arguments pattern
	 * @param listener update listener with {@link CommandContext}
	 * @see CommandContext
	 * @see tech.teslex.telegroo.api.update.CommandUpdateListener
	 */
	default void listenCommand(String pattern, Pattern args, UpdateListener<CommandContext> listener) {
		listenCommand(Pattern.compile(pattern), args, listener);
	}

	/**
	 * Adds commands listener with args.
	 *
	 * @param pattern  command pattern as string
	 * @param args     command arguments pattern
	 * @param listener update listener with {@link CommandContext}
	 * @see CommandContext
	 * @see tech.teslex.telegroo.api.update.CommandUpdateListener
	 */
	default void listenCommand(String pattern, String args, UpdateListener<CommandContext> listener) {
		listenCommand(Pattern.compile(pattern), Pattern.compile(args), listener);
	}

	/**
	 * Removes updates listener.
	 *
	 * @param listener update listener
	 */
	void unlisten(UpdateListener listener);
}