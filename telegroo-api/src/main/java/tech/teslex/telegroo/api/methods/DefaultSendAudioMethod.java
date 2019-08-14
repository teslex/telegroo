package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.SendAudioMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.SendAudio;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSendAudioMethod extends SendAudioMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> sendAudio(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Message> sendAudio(Consumer<SendAudio> data) {
		SendAudio method = SendAudio.create();
		data.accept(method);

		return sendAudio(method);
	}

	@Override
	default TelegramResult<Message> sendAudio(SendAudio data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
