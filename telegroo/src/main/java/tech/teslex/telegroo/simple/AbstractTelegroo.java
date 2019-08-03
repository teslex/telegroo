package tech.teslex.telegroo.simple;

import lombok.extern.slf4j.Slf4j;
import tech.teslex.telegroo.api.Telegroo;
import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.context.CommandContext;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.api.context.MessageContext;
import tech.teslex.telegroo.api.update.UpdateListener;
import tech.teslex.telegroo.api.update.UpdatesHandler;
import tech.teslex.telegroo.simple.client.SimpleTelegramClient;
import tech.teslex.telegroo.simple.context.SimpleContext;
import tech.teslex.telegroo.simple.update.SimpleCommandUpdateListener;
import tech.teslex.telegroo.simple.update.SimpleMessagePatternUpdateListener;
import tech.teslex.telegroo.simple.update.SimpleUpdatesHandler;
import tech.teslex.telegroo.telegram.api.types.update.Update;
import tech.teslex.telegroo.telegram.enums.UpdateType;

import java.util.*;
import java.util.regex.Pattern;

@Slf4j
public abstract class AbstractTelegroo implements Telegroo {

	protected final static Map<UpdateType, Collection<UpdateListener>> listeners = new HashMap<>();
	protected final MainContext mainContext;
	protected final String token;
	protected final TelegramClient telegramClient;
	protected final UpdatesHandler updatesHandler;

	public AbstractTelegroo(String token) {
		this.token = token;
		this.telegramClient = new SimpleTelegramClient(token);
		this.updatesHandler = new SimpleUpdatesHandler();
		this.mainContext = new MainContext(telegramClient, new Update());
	}

	@Override
	public void listen(UpdateListener listener) {
		addListener(listener);
	}

	protected void addListener(UpdateListener listener) {
		log.debug("adding new listener: " + listener);

		if (!listeners.containsKey(listener.getType())) listeners.put(listener.getType(), new ArrayList<>());
		listeners
				.get(listener.getType())
				.add(listener);
	}

	@Override
	public void listenMessage(Pattern pattern, UpdateListener<MessageContext> listener) {
		addListener(new SimpleMessagePatternUpdateListener(pattern, listener));
	}

	@Override
	public void listenCommand(Pattern pattern, UpdateListener<CommandContext> listener) {
		addListener(new SimpleCommandUpdateListener(pattern, null, listener));
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
