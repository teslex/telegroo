package tech.teslex.telegroo.api.methods.defaults.polls;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.polls.StopPollMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.polls.StopPoll;
import tech.teslex.telegroo.telegram.api.types.Poll;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultStopPollMethod extends StopPollMethod<TelegramResult<Poll>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Poll> stopPoll(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Poll> stopPoll(Consumer<StopPoll> data) {
		StopPoll method = StopPoll.create();
		data.accept(method);

		return stopPoll(method);
	}

	@Override
	default TelegramResult<Poll> stopPoll(StopPoll data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Poll.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
