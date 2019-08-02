package tech.teslex.telegroo.simple.update;

import lombok.extern.slf4j.Slf4j;
import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.update.CommandUpdateListener;
import tech.teslex.telegroo.api.update.MessagePatternUpdateListener;
import tech.teslex.telegroo.api.update.UpdateListener;
import tech.teslex.telegroo.api.update.UpdatesHandler;
import tech.teslex.telegroo.simple.context.SimpleCommandContext;
import tech.teslex.telegroo.simple.context.SimpleContext;
import tech.teslex.telegroo.simple.context.SimpleMessageContext;
import tech.teslex.telegroo.telegram.api.types.update.Update;
import tech.teslex.telegroo.telegram.enums.UpdateType;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Slf4j
public class SimpleUpdatesHandler implements UpdatesHandler {

	private static <T> Stream<T> streamOf(Iterable<T> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false);
	}

	@Override
	public Function<TelegramClient, Optional<Update>> handle(Map<UpdateType, Collection<UpdateListener>> listeners, Iterable<Update> updates) {
		return telegramClient -> {
			Update lastHandledUpdate = null;

			for (Update update : updates) {
				log.debug("resolving update: " + update);

				final var updateType = update.getUpdateType();

				@SuppressWarnings("unchecked") final var plainUpdateListeners = listeners.getOrDefault(UpdateType.UPDATE, (Collection<UpdateListener>) Collections.EMPTY_LIST);
				@SuppressWarnings("unchecked") final var updateListeners = listeners.getOrDefault(updateType, (Collection<UpdateListener>) Collections.EMPTY_LIST);

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

	private boolean plainUpdateHandler(Collection<UpdateListener> listeners, Update update, TelegramClient telegramClient) {
		log.debug("resolving plain update: " + update.getUpdateId());
		listeners.forEach(updateListener -> updateListener.onUpdate(new SimpleContext(telegramClient, update)));
		return true; // todo: fix it
	}

	private boolean messageUpdateHandler(Collection<UpdateListener> listeners, Update update, TelegramClient telegramClient) {
		log.debug("resolving message update: " + update.getUpdateId());
		for (UpdateListener listener : listeners) {
			if (listener instanceof MessagePatternUpdateListener) {
				final var pattern = ((MessagePatternUpdateListener) listener).getPattern();
				final var text = update.getMessage().getText();

				if (text != null) {
					final var matcher = pattern.matcher(text);

					if (matcher.matches()) {
						listener.onUpdate(new SimpleMessageContext(telegramClient, update, matcher));
						return true;
					}
				}
			} else if (!(listener instanceof CommandUpdateListener)) {
				listener.onUpdate(new SimpleContext(telegramClient, update));
				return true;
			}
		}

		return false;
	}

	private boolean commandUpdateHandler(Collection<UpdateListener> listeners, Update update, TelegramClient telegramClient) {
		log.debug("resolving command update: " + update.getUpdateId());

		final var commandEntity = update
				.getMessage()
				.getEntities()
				.stream()
				.filter(entity -> entity.getType().equals("bot_command"))
				.findFirst()
				.orElseThrow();

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
				final Optional<Pattern> argsPattern = ((CommandUpdateListener) listener).getArgsPattern();

				final var matcher = commandPattern.matcher(commandString);

				if (matcher.matches()) {
					if (argsPattern.isEmpty()) {
						listener.onUpdate(new SimpleCommandContext(telegramClient, update, matcher, null, argsString));
						return true;
					} else {
						final var argsMatcher = argsPattern.get().matcher(argsString);

						if (argsMatcher.matches()) {
							listener.onUpdate(new SimpleCommandContext(telegramClient, update, matcher, argsMatcher, argsString));
							return true;
						}
					}
				}
			}
		}

		return false;
	}
}
