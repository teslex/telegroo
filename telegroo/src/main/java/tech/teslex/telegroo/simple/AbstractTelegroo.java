package tech.teslex.telegroo.simple;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import tech.teslex.telegroo.api.Telegroo;
import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.context.CommandContext;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.api.context.MessageContext;
import tech.teslex.telegroo.api.jackson.DefaultJacksonObjectMapper;
import tech.teslex.telegroo.api.methods.Methods;
import tech.teslex.telegroo.api.update.CommandUpdateListener;
import tech.teslex.telegroo.api.update.MessagePatternUpdateListener;
import tech.teslex.telegroo.api.update.UpdateListener;
import tech.teslex.telegroo.api.update.UpdatesHandler;
import tech.teslex.telegroo.simple.client.SimpleTelegramClient;
import tech.teslex.telegroo.simple.context.SimpleContext;
import tech.teslex.telegroo.simple.methods.SimpleMethods;
import tech.teslex.telegroo.simple.update.SimpleCommandUpdateListener;
import tech.teslex.telegroo.simple.update.SimpleMessagePatternUpdateListener;
import tech.teslex.telegroo.simple.update.SimpleUpdatesHandler;
import tech.teslex.telegroo.telegram.api.types.update.Update;
import tech.teslex.telegroo.telegram.enums.UpdateType;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Skeleton telegroo implementation
 */
@Slf4j
public abstract class AbstractTelegroo implements Telegroo {

	protected final static Map<UpdateType, Collection<UpdateListener>> listeners = new HashMap<>();
	protected final String token;
	protected final ObjectMapper objectMapper;
	protected final TelegramClient telegramClient;
	protected final UpdatesHandler updatesHandler;
	protected final MainContext mainContext;
	protected final Methods methods;

	public AbstractTelegroo(String token) {
		this.token = token;
		this.objectMapper = DefaultJacksonObjectMapper.getObjectMapper();
		this.telegramClient = new SimpleTelegramClient(token, objectMapper);
		this.updatesHandler = new SimpleUpdatesHandler(objectMapper);
		this.mainContext = new MainContext(telegramClient, new Update());
		this.methods = new SimpleMethods(mainContext, objectMapper);
	}

	@Override
	public void listen(UpdateListener listener) {
		addListener(listener);
	}

	@Override
	public void listenMessage(Pattern pattern, UpdateListener<MessageContext> listener) {
		addListener(new SimpleMessagePatternUpdateListener(pattern, listener));
	}

	@Override
	public void listenMessage(MessagePatternUpdateListener<MessageContext> listener) {
		addListener(listener);
	}

	@Override
	public void listenCommand(Pattern pattern, UpdateListener<CommandContext> listener) {
		addListener(new SimpleCommandUpdateListener(pattern, null, listener));
	}

	@Override
	public void listenCommand(CommandUpdateListener<CommandContext> listener) {
		addListener(listener);
	}

	@Override
	public TelegramClient getTelegramClient() {
		return telegramClient;
	}

	@Override
	public Optional<Update> handleUpdates(Iterable<Update> updates) {
		return updatesHandler
				.handle(new HashMap<>(listeners), updates)
				.apply(telegramClient);
	}

	@Override
	public Context getMainContext() {
		return mainContext;
	}

	@Override
	public void unlisten(UpdateListener listener) {
//		final var flatListeners = listeners
//				.values()
//				.stream()
//				.flatMap(Collection::stream)
//				.collect(Collectors.toList());
//
//		final var toRemove = flatListeners.remove(listener);

		throw new RuntimeException("not implemented");
	}

	@Override
	public Methods methods() {
		return methods;
	}

	protected void addListener(UpdateListener listener) {
		log.debug("adding new listener: " + listener);

		if (!listeners.containsKey(listener.getType()))
			listeners.put(listener.getType(), new ArrayList<>());

		listeners
				.get(listener.getType())
				.add(listener);
	}

	protected static class MainContext extends SimpleContext {

		private Update currentUpdate = new Update();

		MainContext(TelegramClient telegramClient, Update lastUpdate) {
			super(telegramClient, lastUpdate);
		}

		@Override
		public Update getCurrentUpdate() {
			return this.currentUpdate;
		}

		void setCurrentUpdate(Update update) {
			this.currentUpdate = update;
		}
	}
}
