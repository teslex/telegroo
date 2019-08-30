package tech.teslex.telegroo.simple.context;

import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.types.update.Update;

/**
 * Simple Context implementation
 */
public class SimpleContext implements Context {

	private final TelegramClient telegramClient;
	private final Update currentUpdate;

	public SimpleContext(TelegramClient telegramClient, Update currentUpdate) {
		this.telegramClient = telegramClient;
		this.currentUpdate = currentUpdate;
	}

	@Override
	public TelegramClient getTelegramClient() {
		return this.telegramClient;
	}

	@Override
	public Update getCurrentUpdate() {
		return this.currentUpdate;
	}
}
