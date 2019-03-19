package tech.teslex.telegroo.api.methods;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.AnswerCallbackQueryMethodObject;

import java.util.Map;

public interface AnswerCallbackQueryMethod<R> {

	R answerCallbackQuery(Map data);

	@NamedVariant
	R answerCallbackQuery(@NamedDelegate AnswerCallbackQueryMethodObject data);

	R answerCallbackQuery(@DelegatesTo(AnswerCallbackQueryMethodObject.class) Closure closure);
}
