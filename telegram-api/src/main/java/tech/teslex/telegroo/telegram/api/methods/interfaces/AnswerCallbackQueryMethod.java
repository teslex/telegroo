package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.AnswerCallbackQuery;

import java.util.Map;
import java.util.function.Consumer;

public interface AnswerCallbackQueryMethod<R> {

	R answerCallbackQuery(Map data);

	R answerCallbackQuery(AnswerCallbackQuery data);

	R answerCallbackQuery(Consumer<AnswerCallbackQuery.AnswerCallbackQueryBuilder> data);
}
