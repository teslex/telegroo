package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.AnswerCallbackQueryMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.AnswerCallbackQuery;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultAnswerCallbackQueryMethod extends AnswerCallbackQueryMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> answerCallbackQuery(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> answerCallbackQuery(Consumer<AnswerCallbackQuery> data) {
		AnswerCallbackQuery method = AnswerCallbackQuery.create();
		data.accept(method);

		return answerCallbackQuery(method);
	}

	@Override
	default TelegramResult<Object> answerCallbackQuery(AnswerCallbackQuery data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
