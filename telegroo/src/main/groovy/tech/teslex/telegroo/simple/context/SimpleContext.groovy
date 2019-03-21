package tech.teslex.telegroo.simple.context

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Api
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.types.update.Update

import java.util.regex.Matcher

@CompileStatic
class SimpleContext implements MethodsContext {

	private Api api

	private Update lastUpdate

	private ObjectMapper objectMapper

	private Matcher matcher

	protected SimpleContext() {}

	SimpleContext(Api api, Update lastUpdate) {
		this.api = api
		this.lastUpdate = lastUpdate

		this.objectMapper = new ObjectMapper()
		this.objectMapper.registerModule(new Jdk8Module())
		this.objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
	}

	SimpleContext(Api api, Update lastUpdate, Matcher matcher) {
		this.api = api
		this.lastUpdate = lastUpdate
		this.matcher = matcher

		this.objectMapper = new ObjectMapper()
		this.objectMapper.registerModule(new Jdk8Module())
		this.objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
	}

	SimpleContext(Api api, Update lastUpdate, ObjectMapper jacksonObjectMapper) {
		this.api = api
		this.lastUpdate = lastUpdate
		this.objectMapper = jacksonObjectMapper
	}

	SimpleContext(Api api, Update lastUpdate, ObjectMapper jacksonObjectMapper, Matcher matcher) {
		this.api = api
		this.lastUpdate = lastUpdate
		this.objectMapper = jacksonObjectMapper
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

	ObjectMapper getObjectMapper() {
		this.objectMapper
	}

	@Override
	Matcher getMatcher() {
		this.matcher
	}

	@Override
	Context createNewContext(Api api, Update update, Matcher matcher) {
		new SimpleContext(api, update, objectMapper, matcher)
	}

	void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper
	}

	void setLastUpdate(Update update) {
		this.lastUpdate = update
	}
}
