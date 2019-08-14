package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.DeleteMessageMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.DeleteMessage;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultDeleteMessageMethod extends DeleteMessageMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> deleteMessage(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> deleteMessage(Consumer<DeleteMessage> data) {
		DeleteMessage method = DeleteMessage.create();
		data.accept(method);

		return deleteMessage(method);
	}

	@Override
	default TelegramResult<Object> deleteMessage(DeleteMessage data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

	return getContext()
		.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
