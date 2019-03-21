package tech.teslex.telegroo.telegram.methods.interfaces.games;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.games.SendGameMethodObject;

import java.util.Map;

public interface SendGameMethod<R> {

	R sendGame(Map data);

	@NamedVariant
	R sendGame(@NamedDelegate SendGameMethodObject data);

	R sendGame(@DelegatesTo(SendGameMethodObject.class) Closure closure);
}
