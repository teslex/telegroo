package tech.teslex.telegroo.api.context;

import tech.teslex.telegroo.api.TelegramClient;

import java.util.Optional;
import java.util.regex.Matcher;

public interface MessageContext<TC extends TelegramClient> extends MethodsContext<TC> {

	Matcher getMatcher();
}
