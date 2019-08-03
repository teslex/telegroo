package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.EditMessageMedia;

import java.util.Map;
import java.util.function.Consumer;

public interface EditMessageMediaMethod<R> {

	R editMessageMedia(Map data);

	R editMessageMedia(EditMessageMedia data);

	R editMessageMedia(Consumer<EditMessageMedia.EditMessageMediaBuilder> data);
}
