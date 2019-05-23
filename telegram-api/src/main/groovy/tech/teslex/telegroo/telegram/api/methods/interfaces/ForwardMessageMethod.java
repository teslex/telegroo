package tech.teslex.telegroo.telegram.api.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.ForwardMessageMethodObject;

import java.util.Map;

public interface ForwardMessageMethod<R> {

	R forwardMessage(Map data);

	@NamedVariant
	R forwardMessage(@NamedDelegate ForwardMessageMethodObject data);

	R forwardMessage(@DelegatesTo(value = ForwardMessageMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
