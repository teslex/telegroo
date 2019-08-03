package tech.teslex.telegroo.telegram.api.methods.interfaces.payments;

import tech.teslex.telegroo.telegram.api.methods.objects.payments.AnswerShippingQuery;

import java.util.Map;
import java.util.function.Consumer;

public interface AnswerShippingQueryMethod<R> {

	R answerShippingQuery(Map data);

	R answerShippingQuery(AnswerShippingQuery data);

	R answerShippingQuery(Consumer<AnswerShippingQuery.AnswerShippingQueryBuilder> data);
}
