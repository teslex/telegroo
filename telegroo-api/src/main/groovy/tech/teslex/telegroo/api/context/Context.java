package tech.teslex.telegroo.api.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.Api;
import tech.teslex.telegroo.telegram.types.update.Update;

import java.util.Optional;
import java.util.regex.Matcher;

public interface Context<T> extends Cloneable {

	Api<T> getApi();

	void setApi(Api api);

	Update getLastUpdate();

	ObjectMapper getJacksonObjectMapper();

	Optional<Matcher> getMatcher();

	Context createNewContext(Api api, Update update, ObjectMapper objectMapper, Matcher matcher);
}