package tech.teslex.telegroo.telegram.methods.interfaces.games;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.games.GetGameHighScoresMethodObject;

import java.util.Map;

public interface GetGameHighScoresMethod<R> {

	R getGameHighScores(Map data);

	@NamedVariant
	R getGameHighScores(@NamedDelegate GetGameHighScoresMethodObject data);

	R getGameHighScores(@DelegatesTo(value = GetGameHighScoresMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
