package tech.teslex.telegroo.simple.context

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Api
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
	}

	SimpleContext(Api api, Update lastUpdate, Matcher matcher) {
		this.api = api
		this.lastUpdate = lastUpdate
		this.matcher = matcher

		this.jacksonObjectMapper = new ObjectMapper()
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
	Update getLastUpdate() {
		this.lastUpdate
	}

	@Override
	ObjectMapper getJacksonObjectMapper() {
		this.jacksonObjectMapper
	}

	@Override
	Matcher getMatcher() {
		this.matcher
	}

	protected void setApi(Api api) {
		this.api = api
	}

	protected void setLastUpdate(Update lastUpdate) {
		this.lastUpdate = lastUpdate
	}
}
