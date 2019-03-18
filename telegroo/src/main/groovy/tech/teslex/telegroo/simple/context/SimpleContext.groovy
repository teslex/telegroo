package tech.teslex.telegroo.simple.context

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Api
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.telegram.types.update.Update

import java.util.regex.Matcher

@CompileStatic
class SimpleContext implements MethodsContext {

	private Api api

	private Update lastUpdate

	private ObjectMapper jacksonObjectMapper

	private Matcher matcher

	protected SimpleContext() {}

	SimpleContext(Api api, Update lastUpdate) {
		this.api = api
		this.lastUpdate = lastUpdate

		this.jacksonObjectMapper = new ObjectMapper()
		this.jacksonObjectMapper.registerModule(new Jdk8Module())
		this.jacksonObjectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
	}

	SimpleContext(Api api, Update lastUpdate, Matcher matcher) {
		this.api = api
		this.lastUpdate = lastUpdate
		this.matcher = matcher

		this.jacksonObjectMapper = new ObjectMapper()
		this.jacksonObjectMapper.registerModule(new Jdk8Module())
	}

	SimpleContext(Api api, Update lastUpdate, ObjectMapper jacksonObjectMapper) {
		this.api = api
		this.lastUpdate = lastUpdate
		this.jacksonObjectMapper = jacksonObjectMapper
	}

	SimpleContext(Api api, Update lastUpdate, ObjectMapper jacksonObjectMapper, Matcher matcher) {
		this.api = api
		this.lastUpdate = lastUpdate
		this.jacksonObjectMapper = jacksonObjectMapper
		this.matcher = matcher
	}

	@Override
	Api getApi() {
		this.api
	}

	@Override
	void setApi(Api api) {
		this.api = api
	}

	@Override
	Update getLastUpdate() {
		this.lastUpdate
	}

	@Override
	ObjectMapper getJacksonObjectMapper() {
		this.jacksonObjectMapper
	}

	@Override
	Optional<Matcher> getMatcher() {
		Optional.ofNullable(this.matcher)
	}

	@Override
	Context createNewContext(Api api, Update update, ObjectMapper objectMapper, Matcher matcher) {
		new SimpleContext(api, update, objectMapper, matcher)
	}

	protected void setJacksonObjectMapper(ObjectMapper objectMapper) {
		this.jacksonObjectMapper = objectMapper
	}

	protected void setLastUpdate(Update update) {
		this.lastUpdate = update
	}
}
