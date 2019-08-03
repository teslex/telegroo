package tech.teslex.telegroo.telegram.api.methods.interfaces.games;

import tech.teslex.telegroo.telegram.api.methods.objects.games.GetGameHighScores;

import java.util.Map;
import java.util.function.Consumer;

public interface GetGameHighScoresMethod<R> {

	R getGameHighScores(Map data);

	R getGameHighScores(GetGameHighScores data);

	R getGameHighScores(Consumer<GetGameHighScores.GetGameHighScoresBuilder> data);
}
