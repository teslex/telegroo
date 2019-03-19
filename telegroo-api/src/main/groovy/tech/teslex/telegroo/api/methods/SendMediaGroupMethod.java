package tech.teslex.telegroo.api.methods;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.SendMediaGroupMethodObject;

import java.util.Map;

public interface SendMediaGroupMethod<R> {

	R sendMediaGroup(Map data);

	@NamedVariant
	R sendMediaGroup(@NamedDelegate SendMediaGroupMethodObject data);

	R sendMediaGroup(@DelegatesTo(SendMediaGroupMethodObject.class) Closure closure);
}
