package tech.teslex.telegroo.telegram.api.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.SendVideoMethodObject;

import java.util.Map;

public interface SendVideoMethod<R> {

	R sendVideo(Map data);

	@NamedVariant
	R sendVideo(@NamedDelegate SendVideoMethodObject data);

	R sendVideo(@DelegatesTo(value = SendVideoMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
