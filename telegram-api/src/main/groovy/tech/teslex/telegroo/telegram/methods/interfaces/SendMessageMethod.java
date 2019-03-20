package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.SendMessageMethodObject;

import java.util.Map;

public interface SendMessageMethod<R> {

	R sendMessage(Map data);

	@NamedVariant
	R sendMessage(@NamedDelegate SendMessageMethodObject data);

	R sendMessage(@DelegatesTo(SendMessageMethodObject.class) Closure closure);
}