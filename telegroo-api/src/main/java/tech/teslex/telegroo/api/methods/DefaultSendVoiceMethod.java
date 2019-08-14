package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.SendVoiceMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.SendVoice;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSendVoiceMethod extends SendVoiceMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> sendVoice(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Message> sendVoice(Consumer<SendVoice> data) {
		SendVoice method = SendVoice.create();
		data.accept(method);

		return sendVoice(method);
	}

	@Override
	default TelegramResult<Message> sendVoice(SendVoice data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
