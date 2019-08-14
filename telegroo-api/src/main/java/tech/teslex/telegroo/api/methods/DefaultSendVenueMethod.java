package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.SendVenueMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.SendVenue;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSendVenueMethod extends SendVenueMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> sendVenue(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Message> sendVenue(Consumer<SendVenue> data) {
		SendVenue method = SendVenue.create();
		data.accept(method);

		return sendVenue(method);
	}

	@Override
	default TelegramResult<Message> sendVenue(SendVenue data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
