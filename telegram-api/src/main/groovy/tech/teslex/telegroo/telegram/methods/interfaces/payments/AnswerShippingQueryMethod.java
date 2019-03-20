package tech.teslex.telegroo.telegram.methods.interfaces.payments;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.payments.AnswerShippingQueryMethodObject;

import java.util.Map;

public interface AnswerShippingQueryMethod<R> {

	R answerShippingQuery(Map data);

	@NamedVariant
	R answerShippingQuery(@NamedDelegate AnswerShippingQueryMethodObject data);

	R answerShippingQuery(@DelegatesTo(AnswerShippingQueryMethodObject.class) Closure closure);
}
