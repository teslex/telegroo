package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.StopMessageLiveLocationMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.StopMessageLiveLocation;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultStopMessageLiveLocationMethod extends StopMessageLiveLocationMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> stopMessageLiveLocation(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Message> stopMessageLiveLocation(Consumer<StopMessageLiveLocation> data) {
		StopMessageLiveLocation method = StopMessageLiveLocation.create();
		data.accept(method);

		return stopMessageLiveLocation(method);
	}

	@Override
	default TelegramResult<Message> stopMessageLiveLocation(StopMessageLiveLocation data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
