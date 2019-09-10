package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.GetChatMembersCountMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.GetChatMembersCount;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultGetChatMembersCountMethod extends GetChatMembersCountMethod<TelegramResult<Integer>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Integer> getChatMembersCount(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Integer> getChatMembersCount(Consumer<GetChatMembersCount> data) {
		GetChatMembersCount method = GetChatMembersCount.create();
		data.accept(method);

		return getChatMembersCount(method);
	}

	@Override
	default TelegramResult<Integer> getChatMembersCount(GetChatMembersCount data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Integer.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
