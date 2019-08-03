package tech.teslex.telegroo.telegram.api.methods.interfaces.games;

import tech.teslex.telegroo.telegram.api.methods.objects.games.SetGameScore;

import java.util.Map;
import java.util.function.Consumer;

public interface SetGameScoreMethod<R> {

	R setGameScore(Map data);

	R setGameScore(SetGameScore data);

	R setGameScore(Consumer<SetGameScore.SetGameScoreBuilder> data);
}
