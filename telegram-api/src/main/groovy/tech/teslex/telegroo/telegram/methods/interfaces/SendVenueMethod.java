package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.SendVenueMethodObject;

import java.util.Map;

public interface SendVenueMethod<R> {

	R sendVenue(Map data);

	@NamedVariant
	R sendVenue(@NamedDelegate SendVenueMethodObject data);

	R sendVenue(@DelegatesTo(value = SendVenueMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
