package tech.teslex.telegroo.telegram.api.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.SendLocationMethodObject;

import java.util.Map;

public interface SendLocationMethod<R> {

	R sendLocation(Map data);

	@NamedVariant
	R sendLocation(@NamedDelegate SendLocationMethodObject data);

	R sendLocation(@DelegatesTo(value = SendLocationMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
