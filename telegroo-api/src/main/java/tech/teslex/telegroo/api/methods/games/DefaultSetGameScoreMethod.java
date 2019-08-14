package tech.teslex.telegroo.api.methods.games;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.games.SetGameScoreMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.games.SetGameScore;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSetGameScoreMethod extends SetGameScoreMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> setGameScore(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Message> setGameScore(Consumer<SetGameScore> data) {
		SetGameScore method = SetGameScore.create();
		data.accept(method);

		return setGameScore(method);
	}

	@Override
	default TelegramResult<Message> setGameScore(SetGameScore data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
