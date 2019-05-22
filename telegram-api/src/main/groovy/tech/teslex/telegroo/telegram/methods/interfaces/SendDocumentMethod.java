package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.SendDocumentMethodObject;

import java.util.Map;

public interface SendDocumentMethod<R> {

	R sendDocument(Map data);

	@NamedVariant
	R sendDocument(@NamedDelegate SendDocumentMethodObject data);

	R sendDocument(@DelegatesTo(value = SendDocumentMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
