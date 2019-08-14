package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.EditMessageText;

import java.util.Map;
import java.util.function.Consumer;

public interface EditMessageTextMethod<R> {

	R editMessageText(Map data);

	R editMessageText(EditMessageText data);

	R editMessageText(Consumer<EditMessageText> data);
}
