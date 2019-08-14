package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.KickChatMemberMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.KickChatMember;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultKickChatMemberMethod extends KickChatMemberMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> kickChatMember(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> kickChatMember(Consumer<KickChatMember> data) {
		KickChatMember method = KickChatMember.create();
		data.accept(method);

		return kickChatMember(method);
	}

	@Override
	default TelegramResult<Object> kickChatMember(KickChatMember data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
