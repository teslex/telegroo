package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.EditMessageCaption;

import java.util.Map;
import java.util.function.Consumer;

public interface EditMessageCaptionMethod<R> {

	R editMessageCaption(Map data);

	R editMessageCaption(EditMessageCaption data);

	R editMessageCaption(Consumer<EditMessageCaption> data);
}
