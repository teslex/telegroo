package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.GetChatMemberMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.GetChatMember;
import tech.teslex.telegroo.telegram.api.types.ChatMember;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultGetChatMemberMethod extends GetChatMemberMethod<TelegramResult<ChatMember>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<ChatMember> getChatMember(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<ChatMember> getChatMember(Consumer<GetChatMember> data) {
		GetChatMember method = GetChatMember.create();
		data.accept(method);

		return getChatMember(method);
	}

	@Override
	default TelegramResult<ChatMember> getChatMember(GetChatMember data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(ChatMember.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
