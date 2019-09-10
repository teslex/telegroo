package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.EditMessageReplyMarkupMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.EditMessageReplyMarkup;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultEditMessageReplyMarkupMethod extends EditMessageReplyMarkupMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> editMessageReplyMarkup(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Message> editMessageReplyMarkup(Consumer<EditMessageReplyMarkup> data) {
		EditMessageReplyMarkup method = EditMessageReplyMarkup.create();
		data.accept(method);

		return editMessageReplyMarkup(method);
	}

	@Override
	default TelegramResult<Message> editMessageReplyMarkup(EditMessageReplyMarkup data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
