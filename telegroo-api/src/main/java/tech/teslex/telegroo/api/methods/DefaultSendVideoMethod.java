package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.SendVideoMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.SendVideo;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSendVideoMethod extends SendVideoMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> sendVideo(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Message> sendVideo(Consumer<SendVideo> data) {
		SendVideo method = SendVideo.create();
		data.accept(method);

		return sendVideo(method);
	}

	@Override
	default TelegramResult<Message> sendVideo(SendVideo data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
