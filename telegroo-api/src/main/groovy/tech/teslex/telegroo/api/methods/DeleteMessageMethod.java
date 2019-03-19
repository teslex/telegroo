package tech.teslex.telegroo.api.methods;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.DeleteMessageMethodObject;

import java.util.Map;

public interface DeleteMessageMethod<R> {

	R deleteMessage(Map data);

	@NamedVariant
	R deleteMessage(@NamedDelegate DeleteMessageMethodObject data);

	R deleteMessage(@DelegatesTo(DeleteMessageMethodObject.class) Closure closure);
}
