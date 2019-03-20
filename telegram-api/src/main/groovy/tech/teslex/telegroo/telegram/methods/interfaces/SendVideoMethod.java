package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.SendVideoMethodObject;

import java.util.Map;

public interface SendVideoMethod<R> {

	R sendVideo(Map data);

	@NamedVariant
	R sendVideo(@NamedDelegate SendVideoMethodObject data);

	R sendVideo(@DelegatesTo(SendVideoMethodObject.class) Closure closure);
}
