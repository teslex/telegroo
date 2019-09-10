package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.AnswerInlineQueryMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.AnswerInlineQuery;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultAnswerInlineQueryMethod extends AnswerInlineQueryMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> answerInlineQuery(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> answerInlineQuery(Consumer<AnswerInlineQuery> data) {
		AnswerInlineQuery method = AnswerInlineQuery.create();
		data.accept(method);

		return answerInlineQuery(method);
	}

	@Override
	default TelegramResult<Object> answerInlineQuery(AnswerInlineQuery data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
