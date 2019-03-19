package tech.teslex.telegroo.api.methods;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.ForwardMessageMethodObject;

import java.util.Map;

public interface ForwardMessageMethod<R> {

	R forwardMessage(Map data);

	@NamedVariant
	R forwardMessage(@NamedDelegate ForwardMessageMethodObject data);

	R forwardMessage(@DelegatesTo(ForwardMessageMethodObject.class) Closure closure);
}
