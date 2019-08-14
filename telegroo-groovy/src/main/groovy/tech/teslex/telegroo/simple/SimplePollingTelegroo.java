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
			log.warn("bot is already polling");
			return;
		}

		polling.set(true);

		while (polling.get()) {
			TelegramResult<List<Update>> response = methods.getUpdates(
					GetUpdates.create()
							.offset(mainContext.getCurrentUpdate().getUpdateId() + 1));

			handleUpdates(response.getResult())
					.ifPresent(mainContext::setCurrentUpdate);
		}

	}

	@Override
	public void stopPolling() {
		polling.set(false);
	}

	@Override
	public boolean isPolling() {
		return polling.get();
	}
}
