package tech.teslex.telegroo.telegram.api.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.SendContactMethodObject;

import java.util.Map;

public interface SendContactMethod<R> {

	R sendContact(Map data);

	@NamedVariant
	R sendContact(@NamedDelegate SendContactMethodObject data);

	R sendContact(@DelegatesTo(value = SendContactMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
