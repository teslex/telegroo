package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.ForwardMessageMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.ForwardMessage;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultForwardMessageMethod extends ForwardMessageMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> forwardMessage(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Message> forwardMessage(Consumer<ForwardMessage> data) {
		ForwardMessage method = ForwardMessage.create();
		data.accept(method);

		return forwardMessage(method);
	}

	@Override
	default TelegramResult<Message> forwardMessage(ForwardMessage data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
