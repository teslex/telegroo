package tech.teslex.telegroo.telegram.methods.interfaces.games;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.games.SetGameScoreMethodObject;

import java.util.Map;

public interface SetGameScoreMethod<R> {

	R setGameScore(Map data);

	@NamedVariant
	R setGameScore(@NamedDelegate SetGameScoreMethodObject data);

	R setGameScore(@DelegatesTo(SetGameScoreMethodObject.class) Closure closure);
}
