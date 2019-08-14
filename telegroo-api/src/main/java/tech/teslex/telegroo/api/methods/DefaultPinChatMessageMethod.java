package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.PinChatMessageMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.PinChatMessage;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultPinChatMessageMethod extends PinChatMessageMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> pinChatMessage(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> pinChatMessage(Consumer<PinChatMessage> data) {
		PinChatMessage method = PinChatMessage.create();
		data.accept(method);

		return pinChatMessage(method);
	}

	@Override
	default TelegramResult<Object> pinChatMessage(PinChatMessage data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
