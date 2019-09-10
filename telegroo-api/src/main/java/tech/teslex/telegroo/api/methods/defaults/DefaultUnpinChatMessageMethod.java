package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.UnpinChatMessageMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.UnpinChatMessage;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultUnpinChatMessageMethod extends UnpinChatMessageMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> unpinChatMessage(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> unpinChatMessage(Consumer<UnpinChatMessage> data) {
		UnpinChatMessage method = UnpinChatMessage.create();
		data.accept(method);

		return unpinChatMessage(method);
	}

	@Override
	default TelegramResult<Object> unpinChatMessage(UnpinChatMessage data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
