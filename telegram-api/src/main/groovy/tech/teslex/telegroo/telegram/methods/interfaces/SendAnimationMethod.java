package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.SendAnimationMethodObject;

import java.util.Map;

public interface SendAnimationMethod<R> {

	R sendAnimation(Map data);

	@NamedVariant
	R sendAnimation(@NamedDelegate SendAnimationMethodObject data);

	R sendAnimation(@DelegatesTo(value = SendAnimationMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
