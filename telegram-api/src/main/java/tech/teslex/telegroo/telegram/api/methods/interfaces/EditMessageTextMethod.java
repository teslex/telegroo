package tech.teslex.telegroo.telegram.api.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.EditMessageTextMethodObject;

import java.util.Map;

public interface EditMessageTextMethod<R> {

	R editMessageText(Map data);

	@NamedVariant
	R editMessageText(@NamedDelegate EditMessageTextMethodObject data);

	R editMessageText(@DelegatesTo(value = EditMessageTextMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
