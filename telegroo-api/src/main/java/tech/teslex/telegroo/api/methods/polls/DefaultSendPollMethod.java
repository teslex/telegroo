package tech.teslex.telegroo.api.methods.polls;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.polls.SendPollMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.polls.SendPoll;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSendPollMethod extends SendPollMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> sendPoll(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Message> sendPoll(Consumer<SendPoll> data) {
		SendPoll method = SendPoll.create();
		data.accept(method);

		return sendPoll(method);
	}

	@Override
	default TelegramResult<Message> sendPoll(SendPoll data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
