package tech.teslex.telegroo.telegram.api.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.GetUpdatesMethodObject;

import java.util.Map;

public interface GetUpdatesMethod<R> {

	R getUpdates();

	R getUpdates(Map data);

	@NamedVariant
	R getUpdates(@NamedDelegate GetUpdatesMethodObject data);

	R getUpdates(@DelegatesTo(value = GetUpdatesMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
