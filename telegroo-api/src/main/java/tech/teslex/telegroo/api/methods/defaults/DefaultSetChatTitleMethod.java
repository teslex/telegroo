package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.SetChatTitleMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.SetChatTitle;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSetChatTitleMethod extends SetChatTitleMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> setChatTitle(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> setChatTitle(Consumer<SetChatTitle> data) {
		SetChatTitle method = SetChatTitle.create();
		data.accept(method);

		return setChatTitle(method);
	}

	@Override
	default TelegramResult<Object> setChatTitle(SetChatTitle data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
