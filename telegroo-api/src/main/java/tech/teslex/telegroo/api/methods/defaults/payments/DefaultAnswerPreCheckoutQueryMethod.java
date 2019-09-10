package tech.teslex.telegroo.api.methods.defaults.payments;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.payments.AnswerPreCheckoutQueryMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.payments.AnswerPreCheckoutQuery;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultAnswerPreCheckoutQueryMethod extends AnswerPreCheckoutQueryMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> answerPreCheckoutQuery(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> answerPreCheckoutQuery(Consumer<AnswerPreCheckoutQuery> data) {
		AnswerPreCheckoutQuery method = AnswerPreCheckoutQuery.create();
		data.accept(method);

		return answerPreCheckoutQuery(method);
	}

	@Override
	default TelegramResult<Object> answerPreCheckoutQuery(AnswerPreCheckoutQuery data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
