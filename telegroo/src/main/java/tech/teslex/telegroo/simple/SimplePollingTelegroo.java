package tech.teslex.telegroo.simple;

import lombok.extern.slf4j.Slf4j;
import tech.teslex.telegroo.api.PollingTelegroo;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.objects.GetUpdates;
import tech.teslex.telegroo.telegram.api.types.update.Update;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Simple LongPolling Telegram Bot implementation
 */
@Slf4j
public class SimplePollingTelegroo extends AbstractTelegroo implements PollingTelegroo {

	private static final AtomicBoolean polling = new AtomicBoolean(false);

	public SimplePollingTelegroo(String token) {
		super(token);
	}

	@Override
	public void startPolling() {
		if (polling.get()) {
			throw new IllegalStateException("Bot is already polling.");
		}

		log.debug("Starting polling..");

		polling.set(true);

		while (polling.get()) {
			GetUpdates method = GetUpdates
					.create()
					.offset(mainContext.getCurrentUpdate().getUpdateId() + 1);

			TelegramResult<List<Update>> response = methods.getUpdates(method);

			handleUpdates(response.getResult())
					.ifPresent(mainContext::setCurrentUpdate);
		}

	}

	@Override
	public void stopPolling() {
		if (!polling.get()) {
			throw new IllegalStateException("Bot is not polling.");
		}

		log.debug("Stopping polling..");

		polling.set(false);
	}

	@Override
	public boolean isPolling() {
		return polling.get();
	}
}
