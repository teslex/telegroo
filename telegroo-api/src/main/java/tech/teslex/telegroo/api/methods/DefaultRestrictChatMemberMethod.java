package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.RestrictChatMemberMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.RestrictChatMember;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultRestrictChatMemberMethod extends RestrictChatMemberMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> restrictChatMember(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> restrictChatMember(Consumer<RestrictChatMember> data) {
		RestrictChatMember method = RestrictChatMember.create();
		data.accept(method);

		return restrictChatMember(method);
	}

	@Override
	default TelegramResult<Object> restrictChatMember(RestrictChatMember data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
