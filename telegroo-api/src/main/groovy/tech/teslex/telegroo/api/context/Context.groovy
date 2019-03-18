package tech.teslex.telegroo.api.context

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Api
import tech.teslex.telegroo.telegram.types.update.Update

import java.util.Optional
import java.util.regex.Matcher

@CompileStatic
interface Context extends Cloneable {

	Api getApi();

	void setApi(Api api);

	Update getLastUpdate();

	ObjectMapper getJacksonObjectMapper();

	Optional<Matcher> getMatcher();

	Context createNewContext(Api api, Update update, ObjectMapper objectMapper, Matcher matcher);
}