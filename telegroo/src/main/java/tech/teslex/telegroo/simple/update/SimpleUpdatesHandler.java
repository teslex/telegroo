package tech.teslex.telegroo.simple.update;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.update.CommandUpdateListener;
import tech.teslex.telegroo.api.update.MessagePatternUpdateListener;
import tech.teslex.telegroo.api.update.UpdateListener;
import tech.teslex.telegroo.simple.context.SimpleCommandContext;
import tech.teslex.telegroo.simple.context.SimpleContext;
import tech.teslex.telegroo.simple.context.SimpleMessageContext;
import tech.teslex.telegroo.simple.methods.SimpleMethods;
import tech.teslex.telegroo.telegram.api.types.update.Update;
import tech.teslex.telegroo.telegram.enums.UpdateType;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.regex.Pattern;

@Slf4j
public class SimpleUpdatesHandler implements UpdatesHandler {

	private final ObjectMapper objectMapper;

	public SimpleUpdatesHandler(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public <C extends Collection<UpdateListener>> Function<TelegramClient, Optional<Update>> handle(Map<UpdateType, C> listeners, Iterable<Update> updates) {
		return telegramClient -> {
			Update lastHandledUpdate = null;

			for (var update : updates) {
				log.debug("Resolving update: " + update);

				final var updateType = update.getUpdateType();

				@SuppressWarnings("unchecked") final var plainUpdateListeners = listeners.getOrDefault(UpdateType.UPDATE, (C) Collections.EMPTY_LIST);
				@SuppressWarnings("unchecked") final var updateListeners = listeners.getOrDefault(updateType, (C) Collections.EMPTY_LIST);

				if (plainUpdateHandler(plainUpdateListeners, update, telegramClient))
					lastHandledUpdate = update;

				if (updateType == UpdateType.MESSAGE) {
					AtomicBoolean isCommand = new AtomicBoolean(false);

					update
							.getMessage()
							.getEntities()
							.stream()
							.filter(entity -> entity.getType().equals("bot_command"))
							.findFirst()
							.ifPresent(entity -> isCommand.set(true));

					if (isCommand.get()) {
						if (commandUpdateHandler(updateListeners, update, telegramClient))
							lastHandledUpdate = update;
					} else {
						if (messageUpdateHandler(updateListeners, update, telegramClient))
							lastHandledUpdate = update;
					}
				}
			}

			return Optional.ofNullable(lastHandledUpdate);
		};
	}

	//	@SuppressWarnings("unchecked")
	private boolean plainUpdateHandler(Collection<UpdateListener> listeners, Update update, TelegramClient telegramClient) {
		if (update == null)
			return false;

		log.debug("Resolving plain update: " + update.getUpdateId());

		for (var updateListener : listeners) {
			final var context = new SimpleContext(telegramClient, update);
			final var methods = new SimpleMethods(context, objectMapper);

			updateListener.onUpdate(context, methods); /* unchecked */
		}

		return true;
	}

	@SuppressWarnings("unchecked")
	private boolean messageUpdateHandler(Collection<UpdateListener> listeners, Update update, TelegramClient telegramClient) {
		log.debug("Resolving message update: " + update.getUpdateId());
		for (UpdateListener listener : listeners) {
			if (listener instanceof MessagePatternUpdateListener) {
				final var pattern = ((MessagePatternUpdateListener) listener).getPattern();
				final var text = update.getMessage().getText();

				if (text != null) {
					final var matcher = pattern.matcher(text);

					if (matcher.matches()) {
						final var context = new SimpleMessageContext(telegramClient, update, matcher);
						final var methods = new SimpleMethods(context, objectMapper);
						/* unchecked */
						listener.onUpdate(context, methods);
						return true;
					}
				}
			} else if (!(listener instanceof CommandUpdateListener)) {
				final var context = new SimpleContext(telegramClient, update);
				final var methods = new SimpleMethods(context, objectMapper);
				/* unchecked */
				listener.onUpdate(context, methods);
				return true;
			}
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	private boolean commandUpdateHandler(Collection<UpdateListener> listeners, Update update, TelegramClient telegramClient) {
		log.debug("Resolving command update: " + update.getUpdateId());

		final var commandEntity = update
				.getMessage()
				.getEntities()
				.stream()
				.filter(entity -> entity.getType().equals("bot_command"))
				.findFirst()
				.orElseThrow(RuntimeException::new);

		final int startPosition = commandEntity.getOffset() + 1;
		final int endPosition = commandEntity.getOffset() + commandEntity.getLength();

		final String commandString = update.getMessage().getText().substring(startPosition, endPosition);
		var argsString = "";

		if (update.getMessage().getText().length() > endPosition) {
			if (update.getMessage().getText().charAt(endPosition) == ' ') {
				argsString = update.getMessage().getText().substring(endPosition + 1);
			} else {
				argsString = update.getMessage().getText().substring(endPosition);
			}
		}

		for (UpdateListener listener : listeners) {
			if (listener instanceof CommandUpdateListener) {
				final Pattern commandPattern = ((CommandUpdateListener) listener).getPattern();
				/* unchecked */
				final Optional<Pattern> argsPattern = ((CommandUpdateListener) listener).getArgsPattern();

				final var matcher = commandPattern.matcher(commandString);

				if (matcher.matches()) {
					if (argsPattern.isEmpty()) {
						final var context = new SimpleCommandContext(telegramClient, update, matcher, null, argsString);
						final var methods = new SimpleMethods(context, objectMapper);
						/* unchecked */
						listener.onUpdate(context, methods);
						return true;
					} else {
						final var argsMatcher = argsPattern.get().matcher(argsString);

						if (argsMatcher.matches()) {
							final var context = new SimpleCommandContext(telegramClient, update, matcher, argsMatcher, argsString);
							final var methods = new SimpleMethods(context, objectMapper);
							/* unchecked */
							listener.onUpdate(context, methods);
							return true;
						}
					}
				}
			}
		}

		return false;
	}
}
