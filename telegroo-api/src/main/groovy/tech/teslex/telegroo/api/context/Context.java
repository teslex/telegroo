package tech.teslex.telegroo.api.context;

import tech.teslex.telegroo.api.Api;
import tech.teslex.telegroo.telegram.types.update.Update;

import java.util.Optional;
import java.util.regex.Matcher;

public interface Context<T> extends Cloneable {

	Api<T> getApi();

	void setApi(Api api);

	Update getLastUpdate();

	Optional<Matcher> getMatcher();

	Context createNewContext(Api api, Update update, Matcher matcher);
}