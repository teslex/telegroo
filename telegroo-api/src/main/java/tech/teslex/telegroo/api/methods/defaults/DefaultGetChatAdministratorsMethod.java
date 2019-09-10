package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.GetChatAdministratorsMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.GetChatAdministrators;
import tech.teslex.telegroo.telegram.api.types.ChatMember;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public interface DefaultGetChatAdministratorsMethod extends GetChatAdministratorsMethod<TelegramResult<List<ChatMember>>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<List<ChatMember>> getChatAdministrators(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<List<ChatMember>> getChatAdministrators(Consumer<GetChatAdministrators> data) {
		GetChatAdministrators method = GetChatAdministrators.create();
		data.accept(method);

		return getChatAdministrators(method);
	}

	@Override
	default TelegramResult<List<ChatMember>> getChatAdministrators(GetChatAdministrators data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructCollectionType(ArrayList.class, ChatMember.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
