package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.SendContactMethodObject;

import java.util.Map;

public interface SendContactMethod<R> {

	R sendContact(Map data);

	@NamedVariant
	R sendContact(@NamedDelegate SendContactMethodObject data);

	R sendContact(@DelegatesTo(SendContactMethodObject.class) Closure closure);
}
