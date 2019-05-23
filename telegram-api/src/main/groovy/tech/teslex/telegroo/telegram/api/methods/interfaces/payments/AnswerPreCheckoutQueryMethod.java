package tech.teslex.telegroo.telegram.api.methods.interfaces.payments;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.payments.AnswerPreCheckoutQueryMethodObject;

import java.util.Map;

public interface AnswerPreCheckoutQueryMethod<R> {

	R answerPreCheckoutQuery(Map data);

	@NamedVariant
	R answerPreCheckoutQuery(@NamedDelegate AnswerPreCheckoutQueryMethodObject data);

	R answerPreCheckoutQuery(@DelegatesTo(value = AnswerPreCheckoutQueryMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
