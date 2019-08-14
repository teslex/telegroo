package tech.teslex.telegroo.simple.context;

import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.context.CommandContext;
import tech.teslex.telegroo.telegram.api.types.update.Update;

import java.util.regex.Matcher;

public class SimpleCommandContext extends SimpleContext implements CommandContext {

	private final Matcher matcher;

	private final Matcher argsMatcher;

	private final String argsText;

	public SimpleCommandContext(TelegramClient telegramClient, Update lastUpdate, Matcher matcher, Matcher argsMatcher, String argsText) {
		super(telegramClient, lastUpdate);
		this.matcher = matcher;
		this.argsMatcher = argsMatcher;
		this.argsText = argsText;
	}

	@Override
	public Matcher getMatcher() {
		return matcher;
	}

	@Override
	public Matcher getArgsMatcher() {
		return argsMatcher;
	}

	@Override
	public String getArgsText() {
		return argsText;
	}
}
