package tech.teslex.telegroo.simple;

import lombok.extern.slf4j.Slf4j;
import tech.teslex.telegroo.api.PollingTelegroo;
import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.api.update.UpdatesHandler;
import tech.teslex.telegroo.simple.client.SimpleTelegramClient;
import tech.teslex.telegroo.simple.context.SimpleContext;
import tech.teslex.telegroo.simple.update.SimpleUpdatesHandler;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.objects.GetUpdatesMethodObject;
import tech.teslex.telegroo.telegram.api.types.update.Update;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class SimplePollingTelegroo extends AbstractTelegroo implements PollingTelegroo {

	private static final AtomicBoolean polling = new AtomicBoolean(false);

	private final String token;

	private final TelegramClient telegramClient;

	private final MainContext mainContext;

	private final UpdatesHandler updatesHandler;


	public SimplePollingTelegroo(String token) {
		this.token = token;
		this.telegramClient = new SimpleTelegramClient(token);
		this.mainContext = new MainContext(telegramClient, new Update());
		this.updatesHandler = new SimpleUpdatesHandler();
	}

	@Override
	public void startPolling() {
		if (polling.get()) {
			log.warn("bot is already polling");
			return;
		}

		polling.set(true);

		while (polling.get()) {
			TelegramResult<List<Update>> response = mainContext.getUpdates(
					GetUpdatesMethodObject.builder()
							.offset(mainContext.getCurrentUpdate().getUpdateId() + 1)
							.build());

			handleUpdates(response.getResult())
					.ifPresent(mainContext::setCurrentUpdate);
		}

	}

	@Override
	public void stopPolling() {
		polling.set(false);
	}

	@Override
	public TelegramClient getTelegramClient() {
		return telegramClient;
	}

	@Override
	public Context getMainContext() {
		return mainContext;
	}

	@Override
	public Optional<Update> handleUpdates(Iterable<Update> updates) {
		return updatesHandler
				.handle(new HashMap<>(listeners), updates)
				.apply(telegramClient);
	}

	private static class MainContext extends SimpleContext {

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
