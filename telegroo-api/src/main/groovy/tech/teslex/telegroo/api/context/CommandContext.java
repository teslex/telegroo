package tech.teslex.telegroo.api.context;

import tech.teslex.telegroo.api.TelegramClient;

import java.util.regex.Matcher;

public interface CommandContext<TC extends TelegramClient> extends MethodsContext<TC> {

	Matcher getMatcher();

	Matcher getArgsMatcher();

	String getArgsText();
}