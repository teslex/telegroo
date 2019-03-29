package tech.teslex.telegroo.api.context;

import tech.teslex.telegroo.api.Api;
import tech.teslex.telegroo.telegram.types.update.Update;

import java.util.regex.Matcher;

public interface Context<T> {

	Api<T> getApi();

	void setApi(Api api);

	Update getUpdate();

	Matcher getMatcher();

	Context createNewContext(Api api, Update update, Matcher matcher);
}