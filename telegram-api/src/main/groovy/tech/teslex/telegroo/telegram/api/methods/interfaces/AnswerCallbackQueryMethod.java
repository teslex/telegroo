package tech.teslex.telegroo.telegram.api.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.AnswerCallbackQueryMethodObject;

import java.util.Map;

public interface AnswerCallbackQueryMethod<R> {

	R answerCallbackQuery(Map data);

	@NamedVariant
	R answerCallbackQuery(@NamedDelegate AnswerCallbackQueryMethodObject data);

	R answerCallbackQuery(@DelegatesTo(value = AnswerCallbackQueryMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
