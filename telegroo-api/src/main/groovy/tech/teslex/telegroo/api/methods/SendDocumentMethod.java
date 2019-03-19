package tech.teslex.telegroo.api.methods;

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

	R sendDocument(@DelegatesTo(SendDocumentMethodObject.class) Closure closure);
}
