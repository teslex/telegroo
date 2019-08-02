package tech.teslex.telegroo.simple.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.client.TelegramHttpResponse;
import tech.teslex.telegroo.api.jackson.JacksonObjectMapper;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;
import tech.teslex.telegroo.telegram.api.methods.MethodObjectWithFile;
import tech.teslex.telegroo.telegram.api.methods.MethodObjectWithMedia;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SimpleTelegramClient implements TelegramClient {

	private static final ObjectMapper objectMapper = JacksonObjectMapper.getObjectMapper();

	private final String token;

	private final String url = "api.telegram.org";

	private final Map<Object, Object> defaultParams = new HashMap<>();

	public SimpleTelegramClient(String token) {
		this.token = token;
	}

	@Override
	public TelegramHttpResponse go(String method, Map parameters) {
		try {
			return new SimpleTelegramHttpResponse(makeRequest(method, parameters).execute());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public TelegramHttpResponse go(MethodObject methodObject) {
		try {
			return new SimpleTelegramHttpResponse(makeRequest(methodObject).execute());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public TelegramHttpResponse go(MethodObjectWithFile methodObjectWithFile) {
		throw new AssertionError();
	}

	@Override
	public TelegramHttpResponse go(MethodObjectWithMedia methodObjectWithMedia) {
		throw new AssertionError();
	}

	private Request makeRequest(String method, Map parameters) throws JsonProcessingException {
		for (Object o : parameters.entrySet().toArray())
			defaultParams.put(((Map.Entry) o).getKey(), ((Map.Entry) o).getValue());

		return Request.Post(buildUrl(method))
				.useExpectContinue()
				.addHeader("Content-Type", "application/json")
				.bodyString(objectMapper.writeValueAsString(parameters), ContentType.APPLICATION_JSON);
	}

	private Request makeRequest(MethodObject methodObject) throws JsonProcessingException {
		Map parameters = objectMapper.convertValue(methodObject, Map.class);

		for (Object o : parameters.entrySet().toArray())
			defaultParams.put(((Map.Entry) o).getKey(), ((Map.Entry) o).getValue());

		return Request.Post(buildUrl(methodObject.getPathMethod()))
				.useExpectContinue()
				.addHeader("Content-Type", "application/json")
				.bodyString(objectMapper.writeValueAsString(methodObject), ContentType.APPLICATION_JSON);
	}

	private String buildUrl(String method) {
		return "https://" + url + "/bot" + token + "/" + method;
	}

	@Override
	public Map<Object, Object> getDefaultParams() {
		return this.defaultParams;
	}

	@Override
	public void addDefaultParam(Object key, Object value) {
		defaultParams.put(key, value);
	}

	@Override
	public void addDefaultParams(Map<Object, Object> params) {
		defaultParams.putAll(params);
	}

	@Override
	public void removeDefaultParam(Object key) {
		defaultParams.remove(key);
	}

	@Override
	public void clearDefaultParams() {
		defaultParams.clear();
	}
}
