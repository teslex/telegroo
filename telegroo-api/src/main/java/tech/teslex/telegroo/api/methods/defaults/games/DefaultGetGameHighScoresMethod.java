package tech.teslex.telegroo.api.methods.defaults.games;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.games.GetGameHighScoresMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.games.GetGameHighScores;
import tech.teslex.telegroo.telegram.api.types.games.GameHighScore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public interface DefaultGetGameHighScoresMethod extends GetGameHighScoresMethod<TelegramResult<List<GameHighScore>>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<List<GameHighScore>> getGameHighScores(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<List<GameHighScore>> getGameHighScores(Consumer<GetGameHighScores> data) {
		GetGameHighScores method = GetGameHighScores.create();
		data.accept(method);

		return getGameHighScores(method);
	}

	@Override
	default TelegramResult<List<GameHighScore>> getGameHighScores(GetGameHighScores data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructCollectionType(ArrayList.class, GameHighScore.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
