package tech.teslex.telegroo.telegram.api.methods.interfaces.payments;

import tech.teslex.telegroo.telegram.api.methods.objects.payments.AnswerPreCheckoutQuery;

import java.util.Map;
import java.util.function.Consumer;

public interface AnswerPreCheckoutQueryMethod<R> {

	R answerPreCheckoutQuery(Map data);

	R answerPreCheckoutQuery(AnswerPreCheckoutQuery data);

	R answerPreCheckoutQuery(Consumer<AnswerPreCheckoutQuery.AnswerPreCheckoutQueryBuilder> data);
}
