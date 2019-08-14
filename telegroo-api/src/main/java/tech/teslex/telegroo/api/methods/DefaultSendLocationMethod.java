package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.SendLocationMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.SendLocation;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSendLocationMethod extends SendLocationMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> sendLocation(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Message> sendLocation(Consumer<SendLocation> data) {
		SendLocation method = SendLocation.create();
		data.accept(method);

		return sendLocation(method);
	}

	@Override
	default TelegramResult<Message> sendLocation(SendLocation data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
