package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.SendPhoto;

import java.util.Map;
import java.util.function.Consumer;

public interface SendPhotoMethod<R> {

	R sendPhoto(Map data);

	R sendPhoto(SendPhoto data);

	R sendPhoto(Consumer<SendPhoto> data);
}
