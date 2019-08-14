package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.GetChat;

import java.util.Map;
import java.util.function.Consumer;

public interface GetChatMethod<R> {

	R getChat(Map data);

	R getChat(GetChat data);

	R getChat(Consumer<GetChat> data);
}
