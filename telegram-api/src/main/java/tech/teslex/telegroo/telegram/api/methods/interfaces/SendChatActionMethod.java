package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.SendChatAction;

import java.util.Map;
import java.util.function.Consumer;

public interface SendChatActionMethod<R> {

	R sendChatAction(Map data);

	R sendChatAction(SendChatAction data);

	R sendChatAction(Consumer<SendChatAction> data);
}
