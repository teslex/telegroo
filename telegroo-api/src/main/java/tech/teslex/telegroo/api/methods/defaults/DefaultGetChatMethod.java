package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.GetChatMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.GetChat;
import tech.teslex.telegroo.telegram.api.types.Chat;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultGetChatMethod extends GetChatMethod<TelegramResult<Chat>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Chat> getChat(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Chat> getChat(Consumer<GetChat> data) {
		GetChat method = GetChat.create();
		data.accept(method);

		return getChat(method);
	}

	@Override
	default TelegramResult<Chat> getChat(GetChat data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Chat.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
