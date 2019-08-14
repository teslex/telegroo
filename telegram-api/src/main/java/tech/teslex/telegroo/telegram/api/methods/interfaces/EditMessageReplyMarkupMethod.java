package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.EditMessageReplyMarkup;

import java.util.Map;
import java.util.function.Consumer;

public interface EditMessageReplyMarkupMethod<R> {

	R editMessageReplyMarkup(Map data);

	R editMessageReplyMarkup(EditMessageReplyMarkup data);

	R editMessageReplyMarkup(Consumer<EditMessageReplyMarkup> data);
}
