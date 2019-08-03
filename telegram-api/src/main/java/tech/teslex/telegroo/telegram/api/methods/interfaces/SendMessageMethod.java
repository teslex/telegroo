package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.SendMessage;

import java.io.IOException;
import java.util.Map;
import java.util.function.Consumer;

public interface SendMessageMethod<R> {

	R sendMessage(Map data) throws IOException;

	R sendMessage(String text);

	R sendMessage(Long chatId, String text);

	R sendMessage(SendMessage data);

	R sendMessage(Consumer<SendMessage.SendMessageBuilder> data);
}