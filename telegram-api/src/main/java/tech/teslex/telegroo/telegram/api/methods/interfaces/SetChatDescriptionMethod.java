package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.SetChatDescription;

import java.util.Map;
import java.util.function.Consumer;

public interface SetChatDescriptionMethod<R> {

	R setChatDescription(Map data);

	R setChatDescription(SetChatDescription data);

	R setChatDescription(Consumer<SetChatDescription.SetChatDescriptionBuilder> data);
}
