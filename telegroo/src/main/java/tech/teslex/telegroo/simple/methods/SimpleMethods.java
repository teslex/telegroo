package tech.teslex.telegroo.simple.methods;

import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.api.methods.Methods;

public class SimpleMethods implements Methods {

	private final Context context;

	private final ObjectMapper objectMapper;

	public SimpleMethods(Context context, ObjectMapper objectMapper) {
		this.context = context;
		this.objectMapper = objectMapper;
	}

	@Override
	public Context getContext() {
		return context;
	}

	@Override
	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}
}
