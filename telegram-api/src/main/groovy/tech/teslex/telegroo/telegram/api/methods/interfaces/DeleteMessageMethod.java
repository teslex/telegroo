package tech.teslex.telegroo.telegram.api.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.DeleteMessageMethodObject;

import java.util.Map;

public interface DeleteMessageMethod<R> {

	R deleteMessage(Map data);

	@NamedVariant
	R deleteMessage(@NamedDelegate DeleteMessageMethodObject data);

	R deleteMessage(@DelegatesTo(value = DeleteMessageMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
