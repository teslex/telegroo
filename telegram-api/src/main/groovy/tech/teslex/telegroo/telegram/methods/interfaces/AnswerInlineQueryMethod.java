package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.AnswerInlineQueryMethodObject;

import java.util.Map;

public interface AnswerInlineQueryMethod<R> {

	R answerInlineQuery(Map data);

	@NamedVariant
	R answerInlineQuery(@NamedDelegate AnswerInlineQueryMethodObject data);

	R answerInlineQuery(@DelegatesTo(value = AnswerInlineQueryMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
