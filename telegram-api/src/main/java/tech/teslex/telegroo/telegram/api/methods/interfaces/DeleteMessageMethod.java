package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.DeleteMessage;

import java.util.Map;
import java.util.function.Consumer;

public interface DeleteMessageMethod<R> {

	R deleteMessage(Map data);

	R deleteMessage(DeleteMessage data);

	R deleteMessage(Consumer<DeleteMessage.DeleteMessageBuilder> data);
}
