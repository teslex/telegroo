package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.EditMessageTextMethodObject;

import java.util.Map;

public interface EditMessageTextMethod<R> {

	R editMessageText(Map data);

	@NamedVariant
	R editMessageText(@NamedDelegate EditMessageTextMethodObject data);

	R editMessageText(@DelegatesTo(EditMessageTextMethodObject.class) Closure closure);
}
