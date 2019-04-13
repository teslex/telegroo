package tech.teslex.telegroo.api.context;

import tech.teslex.telegroo.api.TelegramClient;
import tech.teslex.telegroo.telegram.types.update.Update;

import java.util.regex.Matcher;

public interface Context<TC extends TelegramClient> {

	TC getTelegramClient();

	void setTelegramClient(TC telegramClient);

	Update getUpdate();

	Matcher getMatcher();

	Context createNewContext(TC telegramClient, Update update, Matcher matcher);
}