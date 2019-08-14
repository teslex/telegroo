package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.SetChatDescriptionMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.SetChatDescription;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSetChatDescriptionMethod extends SetChatDescriptionMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> setChatDescription(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> setChatDescription(Consumer<SetChatDescription> data) {
		SetChatDescription method = SetChatDescription.create();
		data.accept(method);

		return setChatDescription(method);
	}

	@Override
	default TelegramResult<Object> setChatDescription(SetChatDescription data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

	return getContext()
		.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
