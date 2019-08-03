package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.GetChatAdministrators;

import java.util.Map;
import java.util.function.Consumer;

public interface GetChatAdministratorsMethod<R> {

	R getChatAdministrators(Map data);

	R getChatAdministrators(GetChatAdministrators data);

	R getChatAdministrators(Consumer<GetChatAdministrators.GetChatAdministratorsBuilder> data);
}
