package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.SendAudio;

import java.util.Map;
import java.util.function.Consumer;

public interface SendAudioMethod<R> {

	R sendAudio(Map data);

	R sendAudio(SendAudio data);

	R sendAudio(Consumer<SendAudio> data);
}
