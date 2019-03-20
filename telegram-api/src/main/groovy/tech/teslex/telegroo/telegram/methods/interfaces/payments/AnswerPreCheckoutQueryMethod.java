package tech.teslex.telegroo.telegram.methods.interfaces.payments;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.payments.AnswerPreCheckoutQueryMethodObject;

import java.util.Map;

public interface AnswerPreCheckoutQueryMethod<R> {

	R answerPreCheckoutQuery(Map data);

	@NamedVariant
	R answerPreCheckoutQuery(@NamedDelegate AnswerPreCheckoutQueryMethodObject data);

	R answerPreCheckoutQuery(@DelegatesTo(AnswerPreCheckoutQueryMethodObject.class) Closure closure);
}
