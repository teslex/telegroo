package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.SendVideo;

import java.util.Map;
import java.util.function.Consumer;

public interface SendVideoMethod<R> {

	R sendVideo(Map data);

	R sendVideo(SendVideo data);

	R sendVideo(Consumer<SendVideo> data);
}
