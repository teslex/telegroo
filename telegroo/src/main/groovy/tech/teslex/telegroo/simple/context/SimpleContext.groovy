package tech.teslex.telegroo.simple.context

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.transform.CompileStatic
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.TelegramClient
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.types.update.Update

import java.util.regex.Matcher

@CompileStatic
class SimpleContext implements SimpleMethodsContext {

	private TelegramClient<Response> telegramClient

	private Update lastUpdate

	private ObjectMapper objectMapper

	private Matcher matcher

	protected SimpleContext() {}

	SimpleContext(TelegramClient<Response> api, Update lastUpdate, ObjectMapper jacksonObjectMapper) {
		this.telegramClient = api
		this.lastUpdate = lastUpdate
		this.objectMapper = jacksonObjectMapper
	}

	SimpleContext(TelegramClient<Response> api, Update lastUpdate, ObjectMapper jacksonObjectMapper, Matcher matcher) {
		this.telegramClient = api
		this.lastUpdate = lastUpdate
		this.objectMapper = jacksonObjectMapper
		this.matcher = matcher
	}

	@Override
	TelegramClient<Response> getTelegramClient() {
		this.telegramClient
	}

	@Override
	void setTelegramClient(TelegramClient<Response> api) {
		this.telegramClient = api
	}

	@Override
	Update getUpdate() {
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
	Context createNewContext(TelegramClient<Response> telegramClient, Update update, Matcher matcher) {
		new SimpleContext(telegramClient, update, objectMapper, matcher)
	}

	void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper
	}

	void setUpdate(Update update) {
		this.lastUpdate = update
	}
}
