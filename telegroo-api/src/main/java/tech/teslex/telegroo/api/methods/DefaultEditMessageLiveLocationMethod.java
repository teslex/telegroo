package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.EditMessageLiveLocationMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.EditMessageLiveLocation;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultEditMessageLiveLocationMethod extends EditMessageLiveLocationMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> editMessageLiveLocation(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Message> editMessageLiveLocation(Consumer<EditMessageLiveLocation> data) {
		EditMessageLiveLocation method = EditMessageLiveLocation.create();
		data.accept(method);

		return editMessageLiveLocation(method);
	}

	@Override
	default TelegramResult<Message> editMessageLiveLocation(EditMessageLiveLocation data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
