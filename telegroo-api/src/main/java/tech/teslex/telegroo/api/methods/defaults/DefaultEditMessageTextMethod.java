package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.EditMessageTextMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.EditMessageText;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultEditMessageTextMethod extends EditMessageTextMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> editMessageText(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Message> editMessageText(Consumer<EditMessageText> data) {
		EditMessageText method = EditMessageText.create();
		data.accept(method);

		return editMessageText(method);
	}

	@Override
	default TelegramResult<Message> editMessageText(EditMessageText data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
