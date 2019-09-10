package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.LeaveChatMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.LeaveChat;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultLeaveChatMethod extends LeaveChatMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> leaveChat(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> leaveChat(Consumer<LeaveChat> data) {
		LeaveChat method = LeaveChat.create();
		data.accept(method);

		return leaveChat(method);
	}

	@Override
	default TelegramResult<Object> leaveChat(LeaveChat data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
