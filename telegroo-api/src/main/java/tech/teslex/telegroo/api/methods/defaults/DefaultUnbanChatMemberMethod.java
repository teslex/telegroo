package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.UnbanChatMemberMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.UnbanChatMember;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultUnbanChatMemberMethod extends UnbanChatMemberMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> unbanChatMember(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> unbanChatMember(Consumer<UnbanChatMember> data) {
		UnbanChatMember method = UnbanChatMember.create();
		data.accept(method);

		return unbanChatMember(method);
	}

	@Override
	default TelegramResult<Object> unbanChatMember(UnbanChatMember data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

	return getContext()
		.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
