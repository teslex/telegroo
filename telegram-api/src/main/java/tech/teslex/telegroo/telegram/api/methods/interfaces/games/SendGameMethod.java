package tech.teslex.telegroo.telegram.api.methods.interfaces.games;

import tech.teslex.telegroo.telegram.api.methods.objects.games.SendGame;

import java.util.Map;
import java.util.function.Consumer;

public interface SendGameMethod<R> {

	R sendGame(Map data);

	R sendGame(SendGame data);

	R sendGame(Consumer<SendGame> data);
}
