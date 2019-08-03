package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.UnpinChatMessage;

import java.util.Map;
import java.util.function.Consumer;

public interface UnpinChatMessageMethod<R> {

	R unpinChatMessage(Map data);

	R unpinChatMessage(UnpinChatMessage data);

	R unpinChatMessage(Consumer<UnpinChatMessage.UnpinChatMessageBuilder> data);
}
