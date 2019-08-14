package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.AnswerInlineQuery;

import java.util.Map;
import java.util.function.Consumer;

public interface AnswerInlineQueryMethod<R> {

	R answerInlineQuery(Map data);

	R answerInlineQuery(AnswerInlineQuery data);

	R answerInlineQuery(Consumer<AnswerInlineQuery> data);
}
