package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.PinChatMessage;

import java.util.Map;
import java.util.function.Consumer;

public interface PinChatMessageMethod<R> {

	R pinChatMessage(Map data);

	R pinChatMessage(PinChatMessage data);

	R pinChatMessage(Consumer<PinChatMessage> data);
}
