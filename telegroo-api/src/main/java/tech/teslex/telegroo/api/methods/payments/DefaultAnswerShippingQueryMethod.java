package tech.teslex.telegroo.api.methods.payments;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.payments.AnswerShippingQueryMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.payments.AnswerShippingQuery;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultAnswerShippingQueryMethod extends AnswerShippingQueryMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> answerShippingQuery(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> answerShippingQuery(Consumer<AnswerShippingQuery> data) {
		AnswerShippingQuery method = AnswerShippingQuery.create();
		data.accept(method);

		return answerShippingQuery(method);
	}

	@Override
	default TelegramResult<Object> answerShippingQuery(AnswerShippingQuery data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
