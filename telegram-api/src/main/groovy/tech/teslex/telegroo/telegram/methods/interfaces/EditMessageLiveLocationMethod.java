package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.EditMessageLiveLocationMethodObject;

import java.util.Map;

public interface EditMessageLiveLocationMethod<R> {

	R editMessageLiveLocation(Map data);

	@NamedVariant
	R editMessageLiveLocation(@NamedDelegate EditMessageLiveLocationMethodObject data);

	R editMessageLiveLocation(@DelegatesTo(EditMessageLiveLocationMethodObject.class) Closure closure);
}
