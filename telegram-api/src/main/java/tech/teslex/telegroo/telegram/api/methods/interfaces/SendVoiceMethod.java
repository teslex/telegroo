package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.SendVoice;

import java.util.Map;
import java.util.function.Consumer;

public interface SendVoiceMethod<R> {

	R sendVoice(Map data);

	R sendVoice(SendVoice data);

	R sendVoice(Consumer<SendVoice> data);
}
