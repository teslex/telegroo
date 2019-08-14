package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.ForwardMessage;

import java.util.Map;
import java.util.function.Consumer;

public interface ForwardMessageMethod<R> {

	R forwardMessage(Map data);

	R forwardMessage(ForwardMessage data);

	R forwardMessage(Consumer<ForwardMessage> data);
}
