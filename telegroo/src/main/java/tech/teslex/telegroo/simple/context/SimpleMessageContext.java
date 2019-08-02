package tech.teslex.telegroo.simple.context;

import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.context.MessageContext;
import tech.teslex.telegroo.telegram.api.types.update.Update;

import java.util.regex.Matcher;

public class SimpleMessageContext extends SimpleContext implements MessageContext {

	private final Matcher matcher;

	public SimpleMessageContext(TelegramClient telegramClient, Update lastUpdate, Matcher matcher) {
		super(telegramClient, lastUpdate);
		this.matcher = matcher;
	}

	@Override
	public Matcher getMatcher() {
		return matcher;
	}
}
