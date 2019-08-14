package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.SendChatActionMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.SendChatAction;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSendChatActionMethod extends SendChatActionMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> sendChatAction(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> sendChatAction(Consumer<SendChatAction> data) {
		SendChatAction method = SendChatAction.create();
		data.accept(method);

		return sendChatAction(method);
	}

	@Override
	default TelegramResult<Object> sendChatAction(SendChatAction data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

	return getContext()
		.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
