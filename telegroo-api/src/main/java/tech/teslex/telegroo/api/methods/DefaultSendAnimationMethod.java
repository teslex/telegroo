package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.SendAnimationMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.SendAnimation;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSendAnimationMethod extends SendAnimationMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> sendAnimation(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Message> sendAnimation(Consumer<SendAnimation> data) {
		SendAnimation method = SendAnimation.create();
		data.accept(method);

		return sendAnimation(method);
	}

	@Override
	default TelegramResult<Message> sendAnimation(SendAnimation data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
